package com.mLab.geometric.model;

/**
 * Created by nadya on 6/25/14.
 */
public class Section {

    private Point firstPoint;
    private Point secondPoint;

    public Section() {

    }

    public Section(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public double getLength() {
        return firstPoint.distance(secondPoint);
    }

    public boolean belongsTo(Line line) {
        return line.contains(firstPoint) && line.contains(secondPoint);
    }

    public Line getContainingLine() {
        double k  = (firstPoint.getY() - secondPoint.getY()) / (firstPoint.getX() - secondPoint.getX());
        double b  = firstPoint.getY() -k*firstPoint.getX();
        return  new Line(k, b);
    }



    public boolean contains(Point point) {
        boolean lineContains = getContainingLine().contains(point);
        if(!lineContains) {
            return false;
        }

        return (point.getX() >= firstPoint.getX() && point.getX() <= secondPoint.getX()) ||
                (point.getX() <= firstPoint.getX() && point.getX() >= secondPoint.getX());
    }

    public boolean intersectsWithLine(Line line) {
        Line containingLine = getContainingLine();
        Point intersectPoint = line.getIntersectPoint(containingLine);
        if(intersectPoint == null) {
            return false;
        }

        return this.contains(intersectPoint);
    }

    public boolean intersectWithSection(Section newSection) {
        Line firstLine = getContainingLine();
        Line secondLine = newSection.getContainingLine();

        Point intersectPoint = firstLine.getIntersectPoint(secondLine);

        if(intersectPoint == null) {
            return false;
        }
        return firstLine.contains(intersectPoint);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }


}
