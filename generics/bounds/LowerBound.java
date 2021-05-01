package generics.bounds;

import java.util.ArrayList;
import java.util.List;

public class LowerBound {
    //example of a function that uses lower bounded wildcard type parameter
    static void putToList(Integer integer, List<? super Integer> list) {
        list.add(integer);
    }

    public static void main(String... args) {
        List<Integer> ints = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        putToList(5, ints);
        putToList(35, numbers);
        putToList(25, ints);
        putToList(15, numbers);

        // ints.forEach(i -> {});//ok
        // ints.forEach(i -> );//kO
        ints.forEach(i -> System.out.print(i + ", "));
        System.out.println();
        numbers.forEach(i -> System.out.print(i + ", "));

        List<? extends Number> l1 = new ArrayList<>();
        List<? extends Integer> l2 = new ArrayList<>();
        List<? super Number> l3 = new ArrayList<>();
        List<? super Integer> l4 = new ArrayList<>();

        l1 = l2;//ok
        // l2 = l3;//ko
        l4 = l3;//ok
    }
}