import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void Task1(){
        System.out.println("-----Задание №1-----");
        System.out.println("Надо ввести три дроби.");
        FractionNew f = new FractionNew(1, 1);
        System.out.println("Запись числа в виде обыкновенной дроби: " + f);
        System.out.println("Запись в виде десятичной дроби: " + f.getDoubleValue());

        f = new FractionNew(1, 2);
        System.out.println("Запись числа в виде обыкновенной дроби: " + f);
        System.out.println("Запись в виде десятичной дроби: " + f.getDoubleValue());

        f = new FractionNew(1, -3);
        System.out.println("Запись числа в виде обыкновенной дроби: " + f);
        System.out.println("Запись в виде десятичной дроби: " + f.getDoubleValue());
    }

    public static  void Task2(){
        System.out.println("-----Задание №2-----");
        Cat cat = new Cat("Барсик");
        MeowCounter meowCounter = new MeowCounter(cat);

        System.out.println(cat.toString());
        for (int i = 0; i < 5; i++) {
            meowCounter.meow();
        }
        System.out.println("Meow count: " + meowCounter.getMeowCount());
    }

    public static void Task3(){
        System.out.println("-----Задание №3-----");
        List<Integer> L1 = Arrays.asList(1, 1, 2, 3, 4, 5);
        List<Integer> L2 = Arrays.asList(4, 5, 6, 7, 8);

        List<Integer> L = new ArrayList<>();

        for (Integer element : L1) {
            if (!L2.contains(element) && L.indexOf(element) == -1) {
                L.add(element);
            }
        }

        for (Integer element : L2) {
            if (!L1.contains(element) && L.indexOf(element) == -1) {
                L.add(element);
            }
        }

        System.out.println(L);
    }

    private static int getIntInput(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static void Task4(){
        System.out.println("-----Задание №4-----");
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество учеников:");
        int n = getIntInput(scanner, "Нужно ввести целое число");*/
        try {
            File file = new File("src/Task4.txt");
            Scanner scanner = new Scanner(file);
            int n = getIntInput(scanner, "Нужно ввести целое число");

        Map<Integer, List<Integer>> schools = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите информацию о ученике " + (i + 1) + ":");
            System.out.println("Формат: Фамилия Имя Школа Балл");
            String[] input = scanner.nextLine().split(" ");
            System.out.println(input[0] + " " + input[1] + " " + input[2] + " " + input[3]);
            int school = Integer.parseInt(input[2]);
            int score = Integer.parseInt(input[3]);

            if (input.length != 4) {
                System.out.println("Неправильный формат ввода. Повторите попытку.");
                i--;
                continue;
            }

            if (!schools.containsKey(school)) {
                schools.put(school, new ArrayList<>());
            }
            schools.get(school).add(score);
        }

        double totalScore = 0;
        for (List<Integer> scores : schools.values()) {
            for (int score : scores) {
                totalScore += score;
            }
        }
        double averageScore = totalScore / n;

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : schools.entrySet()) {
            if (n >= 5) {
                double average = 0;
                for (int score : entry.getValue()) {
                    average += score;
                }
                average /= entry.getValue().size();
                if (average > averageScore) {
                    result.add(entry.getKey());
                }
            }
        }

        scanner.close();

        System.out.println("Школы с средним баллом выше, чем средний по району:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public static void Task5(){
        try {
            File file = new File("src/Task5.txt");
            Scanner scanner = new Scanner(file);

            StringBuilder builder = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c) && builder.indexOf(String.valueOf(c)) == -1) {
                        builder.append(c + " ");
                    }
                }
            }
            scanner.close();

            System.out.println("Цифры, которые встречаются в тексте:");
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    private static boolean checkEquality(int[] queue, int i, int j) {
        if (i < 0 || j >= queue.length || i >= j) {
            return false;
        }

        int temp = queue[i];
        for (int k = i + 1; k <= j; k++) {
            if (queue[k] != temp) {
                return false;
            }
        }
        return true;
    }

    public static void Task6() {
        int[] queue = {1, 2, 2, 2, 2, 2, 1, 3};
        int i = 1;
        int j = 5;
        System.out.println(checkEquality(queue, i, j));
    }

    public static void Task7_1(){
        Point[] points = {new Point(4, 5), new Point(2, 3), new Point(2, 3), new Point(3, -4), new Point(1, 2)};
        Polyline polyline = new Polyline(Stream.of(points)
                .distinct()
                .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .toArray(Point[]::new));
        System.out.println(polyline);
    }

    public static void Task7_2() throws IOException {
        Map<Integer, String> result = Files.lines(Paths.get("src/Task7.txt"))
                .map(line -> line.split(":"))
                .filter(arr -> arr.length == 2 && !arr[1].isEmpty())
                .collect(Collectors.groupingBy(
                        arr -> Integer.parseInt(arr[1]),
                        Collectors.mapping(
                                arr -> arr[0].substring(0, 1).toUpperCase() + arr[0].substring(1).toLowerCase(),
                                Collectors.joining(", ")
                        )
                ));

        result.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static void main(String[] args) throws IOException {
        //Task1();
        //Task2();
        //Task3();
        //Task4();
        //Task5();
        //Task6();
        //Task7_1();
        Task7_2();
    }
}