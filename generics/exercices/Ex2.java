package generics.exercices;

import java.util.Arrays;

public class Ex2 {
    static <T> void swap(T[] arr, int p1, int p2) {
        T aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }

    public static void main(String... args) {
        Integer[] ints = new Integer[] {1, 4, 6, 9, 0};
        swap(ints, 4, 0);
        Arrays.stream(ints).forEach(s -> System.out.print(s + " "));
    }

    /**

        class Pair {
            public Pair(Object key, Object value) {
                this.key = key;
                this.value = value;
            }
            public Object getKey() {return key;}
            pubic Object getValue() {return value;}
            public void setKey(Object key) {this.key = key;}
            public void setValue(Object value) {this.value = value;}
            private Object key;
            private Object value;
        }

        ------------------------

        public static void print(List<Object> list) {
            for(Object n : list)
                System.out.print(n + " ");
            System.out.println();
        }

        ------------------------
     */
}