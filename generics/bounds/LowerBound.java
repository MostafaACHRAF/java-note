package generics.bounds;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

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

        // l1 = l2;//ok
        // // l2 = l3;//ko
        // l4 = l3;//ok

        l2 = (List<? extends Integer>) l1;//ok
        l4 = (List<? super Integer>) l1;//ok

        String str = "hello";
        Object obj = "hhhh";

        // List<String> strings = new String[] {"abc"}; //ko
        // String[] strs = new ArrayList<>();//ko

        List<String> ll1 = new LinkedList<>();
        // ArrayList<String> ll2 = (ArrayList<String>) ll1;//runtime execption: ClassCastException

        Object[] objs = new String[2];
        objs[0] = "dddd";//ok
        objs[1] = 5;//ko: RuntimeException: ArrayStoreException
        objs[3] = "2222";//ko
    }
}