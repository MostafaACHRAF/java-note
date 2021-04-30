package generics;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Function;

public class GenericMethod {
    public <T> List<T> fromArrayToList(T... array) {
        // T[] data = (T[]) new Object[] {1, 5};
        return Arrays.stream(array).collect(Collectors.toList());
        // return Arrays.asList(array);
    }

    public <T,G> List<G> foo(T[] data, Function<T,G> mapperFunction) {
        return Arrays.stream(data)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    static int i;

    public static void main(String... args) {
        GenericMethod genericMethod = new GenericMethod();
        // Integer[] nbrs = {0, 6, 9, 0, 4};
        // Integer[] arr = null;
        // arr = (Integer[]) new Object[] {"dslkds", 5};
        // List<String> nbrs = list;//heap-pollution. nbrs thinks its referencing a list of string, while in reality its referencing a list of objects
        List<Integer> result = genericMethod.fromArrayToList(1,2);
        // list.add(1,10);
        // list.forEach(System.out::println);

        //#######################
        Integer[] numbers = new Integer[] {2, 5, 6, 7};
        Function<Integer, String> fun = (n) -> {return String.valueOf(n);};
        // List<String> strings = genericMethod.foo(numbers, fun);
        List<String> strings = genericMethod.foo(numbers, (n) -> String.valueOf(n));
        String value = strings.stream().collect(Collectors.joining(","));
        System.out.println("value: " + value);
        if (i < 0) {
            i++;
            main(null);
        }
    }
}