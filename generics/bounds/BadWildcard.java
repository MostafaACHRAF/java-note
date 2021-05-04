package generics.bounds;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.io.Serializable;

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

        List<Integer> l = new ArrayList<>();
        l.add(4);
        l.add(5);
        l.add(7);
        List<? extends Number> ln = new ArrayList<>();
        ln = l;//works because Integers are subtype of Number

        // ln.add(Integer.valueOf(3));//won't compile. Because List<? extends ...> can be thought as read-only
        //but you can still add a null
        //invoke clear method
        //get iterator and invoke remove
        //you can capture wildcard and write elements you've read from the list

        ln.add(null);//ok
        // ln.clear();//ok
        Iterator it = ln.iterator();
        while (it.hasNext()) {
            System.out.println("remove: " + it.next());
            it.remove();
        }
        System.out.println("ln:size: " + ln.size());


        //You can add elements to this list
        List<? super Number> ln2 = new ArrayList<>();
        ln2.add(55);
        // ln2.add("Object");//won't compile
        ln2.add(Double.valueOf(3.4));
        Serializable s = null;
        // ln2.add(s);//ko
    }
}