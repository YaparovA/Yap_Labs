package ru.yaparov.geometry;

public class Square extends GeometricShape {
    private double side;

    public Square(Point p, double side){
        super(p);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getSquare() {
        return side * side;
    }

    @Override
    public void ToString() {
        Point p2,p3,p4;
        p2 = new Point(getPoint().getX() + side, getPoint().getY());
        p3 = new Point(getPoint().getX() + side, getPoint().getY() + side);
        p4 = new Point(getPoint().getX(), getPoint().getY() + side);

        Point[] arrayPoints = new Point[]{getPoint(), p2, p3, p4, getPoint()};
        System.out.print("Квадрат с точками: [");
        for (int i = 0; i < arrayPoints.length; i++){
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
