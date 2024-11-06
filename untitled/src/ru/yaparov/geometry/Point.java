package ru.yaparov.geometry;

public class Point implements Cloneable
{
    private Double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void ToString()
    {
        System.out.printf("{%.3f,%.3f}",x,y);
    }

    @Override
    public boolean equals(Object obj){

        if (!(obj instanceof Point)) return false;

        Point p = (Point)obj;
        return this.x.equals(p.getX()) && this.y.equals(p.getY());
    }

    @Override
    public Point clone() throws CloneNotSupportedException{
        return (Point) super.clone();
    }
}
