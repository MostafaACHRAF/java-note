package generics.exercices;

import java.util.Arrays;
import java.util.List;

public class Ex3 {
    static <E extends Comparable<E>> E maxIn(List<E> list, int begin, int end) {
        E max = list.get(begin);
        // for (int i = begin + 1; i < end; i++) {
        //     if (list.get(i).compareTo(max) > 0) {
        //         max = list.get(i);
        //     }
        // }
        for (++begin; begin < end; ++begin) {
            if (list.get(begin).compareTo(max) > 0) {
                max = list.get(begin);
            }
        }
        return max;
    }

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(2, 5, 6, 7, 9, 0, 2, 0);
        int max = maxIn(list, 0, 5);
        System.out.println("max in [0-5] = " + max);

        List<String> strings = Arrays.asList("A", "B", "c", "z");
        Object max2 = maxIn(strings, 0, 4);
        System.out.println("max in [0-4] = " + max2);

        /**
            class Singleton<T> {
                public static T getInstance() {
                    if (instance == null)
                        instance = new Singleton<T>();
                    return instance;
                }
                private static T instance = null;//won't compile: static attributes can't be of generic type parameter
            }
        
         */
    }
}