package ru.yaparov.input;

import java.util.Scanner;

public class Input {
    public static String ReadString(String text)
    {
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        String inputLine = in.nextLine();
        return inputLine;
    }

    public static int CycleInputInt(String text)
    {
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        String inputLine = in.nextLine();

        while (!InputCheck.isNumber(inputLine)) {
            System.out.println("\nYou can only enter numbers");
            System.out.print(text);
            inputLine = in.nextLine();
        }
        return Integer.parseInt(inputLine);
    }

    public static double CycleInputDouble(String text)
    {
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        String inputLine = in.nextLine();

        while (!InputCheck.isDouble(inputLine)) {
            System.out.println("\nYou can only enter numbers");
            System.out.print(text);
            inputLine = in.nextLine();
        }
        return Double.parseDouble(inputLine);
    }

    public static char GetFirstSymbol(String text)
    {
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();

        while (!InputCheck.isCharNumber(inputLine.charAt(0))) {
            System.out.println("\nYou can only enter char");
            System.out.print(text);
            inputLine = in.nextLine();
        }
        return inputLine.charAt(0);
    }
}
