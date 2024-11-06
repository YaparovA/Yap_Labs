package ru.yaparov.input;

public class InputCheck {
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isCharNumber(char c){
        try {
            if (c >= '0' && c <= '9')
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
