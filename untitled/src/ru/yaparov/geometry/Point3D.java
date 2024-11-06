package ru.yaparov.geometry;

public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z)
    {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double x) {
        this.z = z;
    }
    @Override
    public void ToString()
    {
        System.out.printf("{%.3f,%.3f,%.3f}",super.getX(),super.getY(), z);
    }
}
