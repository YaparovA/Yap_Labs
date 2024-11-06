package ru.yaparov.geometry;

public class Triangle extends GeometricShape {
    private Point p2, p3;

    public Triangle(Point p, Point p2, Point p3){
        super(p);
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getPoint2() {
        return p2;
    }

    public Point getPoint3() {
        return p3;
    }

    public void setPoint2(Point p2) {
        this.p2 = p2;
    }

    public void setPoint3(Point p3) {
        this.p3 = p3;
    }

    @Override
    public double getSquare() {
        double a, b, c, perimeter;
        a = Math.sqrt(Math.pow(getPoint().getX() - getPoint2().getX(), 2) + Math.pow(getPoint().getY() - getPoint2().getY(), 2));
        b = Math.sqrt(Math.pow(getPoint2().getX() - getPoint3().getX(), 2) + Math.pow(getPoint2().getY() - getPoint3().getY(), 2));
        c = Math.sqrt(Math.pow(getPoint().getX() - getPoint3().getX(), 2) + Math.pow(getPoint().getY() - getPoint3().getY(), 2));
        perimeter = (a + b + c) / 2;

        return  Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }

    @Override
    public void ToString() {
        Point[] arrayPoints = new Point[]{getPoint(), p2, p3, getPoint()};
        System.out.print("Треугольник с точками: [");
        for (int i = 0; i < arrayPoints.length; i++) {
            arrayPoints[i].ToString();
        }
        System.out.print("]");
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
