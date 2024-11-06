package ru.yaparov.main;

import ru.yaparov.geometry.*;
import ru.yaparov.input.*;
import ru.yaparov.phone.PhoneBook;
import ru.yaparov.student.Student;

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

    public static void main(String[] args) throws Exception {


        boolean workCondition = true;
        int[] arrayForInput;
        int arraySize;
        Point p1, p2, p3;

        while (workCondition) {
            System.out.println("\nСписок заданий:" +
                    "\n1.Первое задание" +
                    "\n2.Второе задание" +
                    "\n3.Третье задание" +
                    "\n4.Четвертое задание + пятое задание" +
                    "\n5.Шестое задание" +
                    "\n6.Седьмое задание" +
                    "\n7.Восьмое задание" +
                    "\n0.Выход");

            int exerciseNum = Input.CycleInputInt("Введите номер задания:");
            switch (exerciseNum) {
                case 1:
                    System.out.print("\nПроверка задания 1.9 про студента");
                    String studentName = Input.ReadString("\nВведите Имя студента:");
                    arraySize = Input.CycleInputInt("Введите количество добавляемых оценок:");
                    arrayForInput = new int[arraySize];
                    for (int i = 0; i < arrayForInput.length; i++) {
                        System.out.printf("\nОценка №%d: ", i + 1);
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите оценку №%d:", i + 1));
                    }
                    Student student = new Student(studentName, arrayForInput);
                    System.out.print("Созданный студент:");
                    student.ToString();
                break;
                case 2:
                    System.out.print("\nПроверка задания 2.3 про телефонный справочник");
                    PhoneBook book = new PhoneBook("Иван", "89195553535");
                    book.Add("Петр", "89205553535");
                    book.Add("Алексей", "89215553535");
                    arraySize = Input.CycleInputInt("\nВведите количество наборов пар:");
                    String nameInBook, phoneInBook;
                    for (int i = 0; i < arraySize; i++) {
                        nameInBook = Input.ReadString("\nВведите Имя:");
                        phoneInBook = Input.ReadString("\nВведите номер телефона:");
                        book.Add(nameInBook, phoneInBook);
                    }
                    nameInBook = Input.ReadString("\nУдаление номера по имени. Введите Имя:");
                    book.Delete(nameInBook);
                    nameInBook = book.ToString();
                    System.out.println(nameInBook);
                    nameInBook = Input.ReadString("\nПолучение номера по имени. Введите Имя:");
                    System.out.println("Номер телефона: " + book.Get(nameInBook));
                    phoneInBook = Input.ReadString("\nПроверка конкретного номера. Введите номер:");
                    if (book.ExistNumber(phoneInBook))
                        System.out.println("Такой номер в справочнике есть");
                    else
                        System.out.println("Такого номера в справочнике нет");
                    System.out.println("Количество номеров в справочнике: " + book.Count());
                    nameInBook = Input.ReadString("\nПоиск имен по его части. Введите Имя: ");
                    String[] list = book.Search(nameInBook);
                    for (int i = 0; i < list.length; i++)
                    {
                        System.out.println(list[i]);
                    }
                break;
                case 3:
                    System.out.print("\nЗадание про точку в трехмерной системе координат.\n");
                    arrayForInput = new int[3];
                    for (int i = 0; i < arrayForInput.length; i++)
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите координату №%d (" +
                                "№1 - x,№2 - y,№3 - z в таком порядке):", i + 1));
                    Point3D p = new Point3D(1, 2, 3);
                    p.ToString();
                break;
                case 4:
                    System.out.print("\nЗадание про фигуры\n");
                    arrayForInput = new int[2];
                    double tmpValue, tmpValue2;
                    for (int i = 0; i < arrayForInput.length; i++)
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите координату №%d (" +
                                "№1 - x,№2 - y в таком порядке):", i + 1));
                    tmpValue = Input.CycleInputDouble("Введите радиус круга: ");
                    Circle c = new Circle(new Point(arrayForInput[0], arrayForInput[1]), tmpValue);
                    System.out.printf("Площадь круга: %f\n", c.getSquare());
                    tmpValue = Input.CycleInputDouble("Введите сторону квадрата: ");
                    Square s = new Square(new Point(arrayForInput[0], arrayForInput[1]), tmpValue);
                    System.out.printf("Площадь квадрата: %f\n", s.getSquare());
                    tmpValue = Input.CycleInputDouble("Введите сторону прямоугольника №1: ");
                    tmpValue2 = Input.CycleInputDouble("Введите сторону прямоугольника №2: ");
                    Rectangle r = new Rectangle(new Point(arrayForInput[0], arrayForInput[1]), tmpValue, tmpValue2);
                    System.out.printf("Площадь прямоугольника: %f\n", r.getSquare());
                    for (int i = 0; i < arrayForInput.length; i++)
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите координату №%d (" +
                                "№1 - x,№2 - y в таком порядке):", i + 1));
                    p1 = new Point(arrayForInput[0], arrayForInput[1]);
                    for (int i = 0; i < arrayForInput.length; i++)
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите координату №%d (" +
                                "№1 - x,№2 - y в таком порядке):", i + 1));
                    p2 = new Point(arrayForInput[0], arrayForInput[1]);
                    for (int i = 0; i < arrayForInput.length; i++)
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите координату №%d (" +
                                "№1 - x,№2 - y в таком порядке):", i + 1));
                    p3 = new Point(arrayForInput[0], arrayForInput[1]);
                    Triangle t = new Triangle(p1, p2, p3);
                    System.out.printf("Площадь треугольника: %f\n", t.getSquare());

                    System.out.printf("Площадь всех фигур %f\n", c.TotalSquare(c,s,r,t));
                    s.ToString();
                    System.out.println();

                break;
                case 5:
                    System.out.print("\nВведите две точки для их сравнения\n");
                    arrayForInput = new int[2];
                    for (int i = 0; i < arrayForInput.length; i++)
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите координату №%d (" +
                                "№1 - x,№2 - y в таком порядке):", i + 1));
                    p1 = new Point(arrayForInput[0], arrayForInput[1]);
                    for (int i = 0; i < arrayForInput.length; i++)
                        arrayForInput[i] = Input.CycleInputInt(String.format("Введите координату №%d (" +
                                "№1 - x,№2 - y в таком порядке):", i + 1));
                    p2 = new Point(arrayForInput[0], arrayForInput[1]);
                    if (p1.equals(p2))
                        System.out.println("Точки совпадают");
                    else
                        System.out.println("Точки не совпадают");
                break;
                case 6:
                    if (args.length >= 2 )
                        System.out.printf("Возведение в степень: %.2f\n", Pow(args[0], args[1]));
                    else
                        System.out.println("Нужно добавить два аргумента через кончоль");
                break;
                case 7:
                    System.out.print("\nПроверка копирования точки\n");
                    try {
                        Point original = new Point(2, 2);
                        System.out.print("Оригинальная точка: ");
                        original.ToString();
                        System.out.println();
                        Point clone = (Point)original.clone();
                        original.setX(100);
                        System.out.print("Оригинальная точка после изменения: ");
                        original.ToString();
                        System.out.println();
                        System.out.print("Клон точки: ");
                        clone.ToString();
                        System.out.println();
                    }
                    catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                break;
                case 0: workCondition = false;
                break;
            }
        }

    }
}