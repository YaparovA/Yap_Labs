package ru.yaparov.geometry;

public class Circle extends GeometricShape {
    private double radius;

    public Circle(Point p, double radius){
        super(p);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getSquare() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public void ToString() {
        System.out.printf("Координаты центра круга {%f,%f}, с радиусом %f", getPoint().getX(), getPoint().getY(), radius);
    }

    @Override
    public double TotalSquare(GeometricShape... args){
        double result = 0;
        for (GeometricShape arg : args) {
            result += arg.getSquare();
        }
        return result;
    }
}
