import java.util.*;
import java.lang.reflect.Array;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("-----Тестирование задания 1-----");

        Student V = new Student("Вася", new int[]{3,4,5,5});
        Student P = new Student("Петя", new int[]{3,2,5,5});
        Student O = new Student("Олег", new int[]{3,4,5,5});
        Student T = new Student("Толя", new int[]{3,5,5,5});

        V.ToString();
        P.ToString();
        O.ToString();
        T.ToString();

        System.out.println("Результат сравнения оценок Васи и Пети: " + V.compareTo(P));
        System.out.println("Результат сравнения оценок Васи и Олега: " + V.compareTo(O));
        System.out.println("Результат сравнения оценок Васи и Толи: " + V.compareTo(T));

        System.out.println();
        System.out.println("-----Тестирование задания 2-----");

        Box testBox = new Box();
        testBox = superClass.PointInBox(testBox);
        System.out.println("Точка созданная методом PointInBox: " + testBox.get().toString());
        System.out.println("Проверка свободна ли коробка: " + testBox.IsEmpty());


        System.out.println();
        System.out.println("-----Тестирование задания 3-----");

        exerciseThree ex = new exerciseThree();
        List<String> strings = List.of("qwerty", "asdfg", "zx", "zx");
        System.out.println("Исходные данные: " + strings);
        System.out.println("Результат работы метода apply над строками: " + ex.apply(strings, String::length));

        List<Integer> numbers = List.of(1, -3, 7);
        System.out.println("Исходные данные: " + numbers);
        System.out.println("Результат работы метода apply над числами: " + ex.apply(numbers, a -> Math.abs(a)));

        List<int[]> listOfArrays = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{-4, -5, -6},
                new int[]{-7, 8, 9});
        System.out.println("Исходные данные: ");
        listOfArrays.forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println("Результат работы метода apply над массивами: " + ex.apply(listOfArrays, a->Arrays.stream(a).max().orElseThrow()));

        System.out.println();

        System.out.println("Исходные данные: " + strings);
        System.out.println("Результат работы метода filter над строками: " + ex.filter(strings, a -> a.length() >= 3));

        System.out.println("Исходные данные: " + numbers);
        System.out.println("Результат работы метода filter над числами: " + ex.filter(numbers, a -> a <= 0));

        System.out.println("Исходные данные: ");
        listOfArrays.forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println("Результат работы метода filter над массивами: ");
        List<int[]> newArrays = ex.filter(listOfArrays, a -> Arrays.stream(a).allMatch(x -> x <= 0));
        newArrays.forEach(a -> System.out.println(Arrays.toString(a)));

        System.out.println();

        System.out.println("Исходные данные: " + strings);
        System.out.println("Результат работы метода reduce над строками: " + ex.reduce(strings, (a,b) -> a + b, ""));

        System.out.println("Исходные данные: " + numbers);
        System.out.println("Результат работы метода reduce над числами: " + ex.reduce(numbers, (a,b) -> a + b, 0));

        System.out.println("Исходные данные: ");
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );
        for (List<Integer> innerList : listOfLists) {
            System.out.println(innerList);
        }
        System.out.println("Результат работы метода reduce: " + ex.reduce(listOfLists,
                (list1, list2) -> {
                    List<Integer> newList = new ArrayList<>(list1);
                    newList.addAll(list2);
                    return newList;
                },
                new ArrayList<>()
        ).size());

        System.out.println();

        System.out.println("Исходные данные: " + numbers);
        Map<Boolean, List<Integer>> groupNumbers = ex.collectToMap(
                numbers,
                HashMap::new,
                list -> list.stream()
                        .collect(Collectors.partitioningBy(a -> a >= 0))
        );
        System.out.println("Результат работы метода collect над числами(положительные): " + groupNumbers.get(true));
        System.out.println("Результат работы метода collect над числами(отрицательные): " + groupNumbers.get(false));

        System.out.println("Исходные данные: " + strings);
        Map<Integer, List<String>> groupStrings = ex.collectToMap(
                strings,
                HashMap::new,
                list -> list.stream()
                        .collect(Collectors.groupingBy(String::length))
        );
        System.out.println("Результат работы метода collect над строками: " + groupStrings);

        System.out.println("Исходные данные: " + strings);
        Set<String> groupStrings2 = ex.collect(
                strings,
                HashSet::new,
                list -> new ArrayList<>(new HashSet<>(list))
        );
        System.out.println("Результат работы метода collect над строками: " + groupStrings2);

    }
}