package ru.yaparov.geometry;

abstract public class GeometricShape {
    private Point p;

    public GeometricShape(Point p){
        this.p = p;
    }

    public Point getPoint() {
        return p;
    }

    public void setPoint(Point p) {
        this.p = p;
    }

    public abstract double getSquare();

    public abstract void ToString();

    public abstract double TotalSquare(GeometricShape... args);
}
