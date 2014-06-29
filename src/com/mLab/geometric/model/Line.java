package com.mLab.geometric.model;

/**
 * Created by nadya on 6/25/14.
 */
public class Line {
    private double k;
    private double b;

    public Line() {
    }

    public Line(double x, double y) {
        this.k = x;
        this.b = y;
    }

    public boolean contains(Point point) {
        return k * point.getX() + b == point.getY();
    }

    public boolean intersects(Line line) {
        return this.k != line.k;
    }

    public Point getIntersectPoint(Line line) {
        if(!line.intersects(this)) {
            return null;
        }
        double x = (this.b -line.b)/(this.k - line.k);
        double y = k*x + b;

        return new Point(x,y);
    }
}
