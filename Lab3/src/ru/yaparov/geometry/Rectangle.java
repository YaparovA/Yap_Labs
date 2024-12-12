package ru.yaparov.geometry;

public class Rectangle extends Square {
    private double sideTwo;

    public Rectangle(Point p, double sideOne, double sideTwo){
        super(p, sideOne);
        this.sideTwo = sideTwo;
    }

    public double getSideTwo() {
        return sideTwo;
    }

    public void setSideTwo(double sideTwo) {
        this.sideTwo = sideTwo;
    }

    @Override
    public double getSquare(){
        return getSide() * sideTwo;
    }

    @Override
    public void ToString() {
        Point p2,p3,p4;
        p2 = new Point(getPoint().getX() + getSide(), getPoint().getY());
        p3 = new Point(getPoint().getX() + getSide(), getPoint().getY() + sideTwo);
        p4 = new Point(getPoint().getX(), getPoint().getY() + sideTwo);

        Point[] arrayPoints = new Point[]{getPoint(), p2, p3, p4, getPoint()};
        System.out.print("Прямоугольник с точками: [");
        for (int i = 0; i < arrayPoints.length; i++){
            arrayPoints[i].ToString();
        }
        System.out.print("]");

    }
}
