import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("-----Тестирование задания №1-----");
        Human h = new Human("Старый", 750);
        System.out.println("Исходные данные: " + h.toString());
        System.out.println("Результат работы validate (будут выведены сообщения методов, которые не прошли тесты):");
        try {
            Validator.validate(h);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("-----Тестирование задания №3-----");
        Human h2 = new Human("Молодой", 1);
        Human h3 = new Human("Молодоооооооооооооооооооооооооооооооооооооооооооооооооооооооооой", 5);

        System.out.println("Исходные данные: " + h2.toString());
        System.out.println("Исходные данные: " + h3.toString());

        System.out.println("Результат работы validate (будут выведены сообщения методов, которые не прошли тесты):");
        try {
            Validator.validate(h2, h3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}