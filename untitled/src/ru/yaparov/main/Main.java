package ru.yaparov.main;

import ru.yaparov.geometry.*;

public class Main {
    public static double Pow(String x, String y){
        int intX, intY;
        try{
            intX = Integer.parseInt(x);
            intY = Integer.parseInt(y);
        }
        catch (Exception e){
            System.out.println("Ошибка с входными аргументами");
            e.printStackTrace();
            return 0;
        }
        return Math.pow(intX, intY);
    }

    public static void main(String[] args) {
        Point3D p = new Point3D(1, 2, 3);
        System.out.print(p.getY());
        System.out.println();
        p.ToString();
        System.out.println();

        System.out.println();
        Circle c = new Circle(new Point(1, 1), 3);
        System.out.printf("Площадь круга: %f\n", c.getSquare());
        Square s = new Square(new Point(1,1), 3);
        System.out.printf("Площадь квадрата: %f\n", s.getSquare());
        Rectangle r = new Rectangle(new Point(1,1), 3, 2);
        System.out.printf("Площадь прямоугольника: %f\n", r.getSquare());
        Triangle t = new Triangle(new Point(1,1), new Point(3, 1), new Point(1, 3));
        System.out.printf("Площадь треугольника: %f\n", t.getSquare());

        System.out.printf("Площадь всех фигур %f\n", c.TotalSquare(c,s,r,t));
        s.ToString();
        System.out.println();

        if (p.equals(new Point(1, 2)))
            System.out.println("Точки совпадают");

        if (!p.equals(new Point(1, 3)))
            System.out.println("Точки не совпадают");

        if (args.length >= 2 )
            System.out.printf("Возведение в степень: %.2f\n", Pow(args[0], args[1]));


        try {
            Point original = new Point(2, 2);
            Point clone = (Point)original.clone();
            original.setX(100);
            System.out.print("Оригинальная точка: ");
            original.ToString();
            System.out.println();
            System.out.print("Клон точки: ");
            clone.ToString();
            System.out.println();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}