package com.mLab.geometric.model;

import java.awt.geom.PathIterator;
import java.util.Set;

/**
 * Created by nadya on 6/25/14.
 */
public class Polygon {
    private int count;
    private Point[] polygonPoints = new Point[count];

    public Polygon(int count, Point[] polygonPoints) {
        this.count = count;
        this.polygonPoints = polygonPoints;
    }

    public boolean isPointIntoPolygon(Point point) {

        int i;
        int j;

        for (i = 0, j = count - 1; i < count; j = i++) {
            if ((polygonPoints[i].getY() > point.getY()) != (polygonPoints[j].getY() > point.getY()) &&
                    (point.getX() < (polygonPoints[j].getX() - polygonPoints[i].getX()) * (point.getY() - polygonPoints[i].getY()) / (polygonPoints[j].getY()-polygonPoints[i].getY()) + polygonPoints[i].getY())) {
                return true;
            }
        }

        return false;
    }

    public boolean isSectionIntoPolygon(Section section) {

        int i;
        int j;

        for (i = 0, j = count - 1; i < count; j = i++) {
            if (isPointIntoPolygon(section.getSecondPoint()) && isPointIntoPolygon(section.getSecondPoint())) {
                return true;
            }
        }

        return false;
    }


    private Section[] polygonSections() {

        Section[] polygonSections = new Section[count];

        Point point = polygonPoints[0];

        for(int i = 1; i < count-1; i ++) {

            polygonSections[i-1] = new Section(point,polygonPoints[i]);

        }
        polygonSections[count-1] = new Section(polygonPoints[count-1], point);

        return polygonSections;

    }



    public int intersectSectionPoints(Section section) {
        Section[] polygonSection = polygonSections();

        Point[] intersectPoints = new Point[2];
        int count = 0;
        for(int i = 0; i < count; i ++) {
            if(section.intersectWithSection(polygonSection[i])) {
                Line firstLine = section.getContainingLine();
                Line secondLine = polygonSection[i].getContainingLine();
                intersectPoints[count] = firstLine.getIntersectPoint(secondLine);
                count ++;
            }
        }

        return count;
    }

}
