import java.util.*;
import java.util.function.*;

public class exerciseThree {

    public exerciseThree(){}

    /*public <P, T> List<P> Apply(List<T> args){
        List<P> result = new ArrayList<P>();
        if (args.get(0) instanceof String)
            for (int i = 0; i < args.size(); i++)
                result.add((P)(Integer)args.get(i).toString().length());

        if (args.get(0) instanceof Integer)
            for (int i = 0; i < args.size(); i++)
                result.add((P)(Integer)Math.abs((Integer)args.get(i)));

        if (args.get(0) instanceof Integer[])
            for (int i = 0; i < args.size(); i++) {
                Integer[] array = (Integer[])args.get(i);
                result.add((P) (Integer)Arrays.stream(array).max(Integer::compare).get());
            }
        return result;
    }*/
    public static <T, P> List<P> apply(List<T> inputList, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T element : inputList) {
            result.add(function.apply(element));
        }
        return result;
    }

    /*public <P, T> List<P> Test(List<T> args) {
        List<P> result = new ArrayList<P>();
        if (args.get(0) instanceof String)
            for (int i = 0; i < args.size(); i++)
                if(args.get(i).toString().length() >= 3)
                    result.add((P)(String)args.get(i));

        if (args.get(0) instanceof Integer)
            for (int i = 0; i < args.size(); i++)
                if((Integer)args.get(i) >= 0)
                    result.add((P)(Integer)args.get(i));

        if (args.get(0) instanceof Integer[])
            for (int i = 0; i < args.size(); i++) {
                Integer[] array = (Integer[])args.get(i);
                if ((Integer)Arrays.stream(array).min(Integer::compare).get() >= 0)
                    result.add((P) (Integer[]) args.get(i));
            }
        return result;
    }*/

    public static <T> List<T> filter(List<T> inputList, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T element : inputList) {
            if (condition.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
    /*public static <T> T reduce(List<T> source, BiFunction<T, T, T> func) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        T result = source.get(0);
        for (int i = 1; i < source.size(); i++) {
            result = func.apply(result, source.get(i));
        }

        return result;
    }*/
    public <T> T reduce(List<T> inputList, BinaryOperator<T> reducer, T identity) {
        T result = identity;
        for (T element : inputList) {
            result = reducer.apply(result, element);
        }
        return result;
    }

    public <T, P extends Collection<T>> P collect( List<T> inputList, Supplier<P> collectionFactory, Function<List<T>, List<T>> collectorFunction) {
        P result = collectionFactory.get();
        result.addAll(collectorFunction.apply(inputList));
        return result;
    }
    public <T, K, V> Map<K, V> collectToMap(List<T> inputList, Supplier<Map<K, V>> mapFactory, Function<List<T>, Map<K, V>> mapFunction) {
        Map<K, V> result = mapFactory.get();
        result.putAll(mapFunction.apply(inputList));
        return result;
    }
}
