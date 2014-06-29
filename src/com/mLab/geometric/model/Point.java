package com.mLab.geometric.model;

/**
 * Created by nadya on 6/25/14.
 */
public class Point {
    private double x;
    private double y;


    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point distance) {

        return Math.sqrt((this.getX()-distance.getX())*(this.getX()-distance.getX())+(this.getY()-distance.getY())*(this.getY()-distance.getY()));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


}
