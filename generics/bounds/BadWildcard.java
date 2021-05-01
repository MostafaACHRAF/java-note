package generics.bounds;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BadWildcard {
    static void fooSwap(List<? extends Number> l1, List<? extends Number> l2) {
        Number n = l1.get(0);
        // l1.set(0, l2.get(0));//ko, compiler can't infer l2.get(0) type is CAP#2
        // l2.set(0, n);//ko
    }

    static <T> void fooHelper(List<T> l) {
        l.set(0, l.get(1));
    }

    static void fooSet(List<?> l) {
        // l.set(0, l.get(1));//won't compile, because the compiler can't infer the type of the element to add to the list!
        //A solution whould be to use a helper, to help the compiler to determine that T is CAP#1 using inference
        fooHelper(l);
    }

    public static void main(String... args) {
        List<Integer> ints = Arrays.asList(1,3,4);
        List<Double> doubles = Arrays.asList(2.3, 5.0, 4.9);

        // fooSwap(ints, doubles);//won't compile because we are trying to insert integers in a list of doubles
    }
}