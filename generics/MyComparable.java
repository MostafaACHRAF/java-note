package generics;

public class MyComparable {
    // static <T> int countGreatherThan(T[] arr, T elem) {
    //     int count = 0;
    //     for(T e : arr) {
    //         if (e > elem) {//this line won't compile because '>' works only with primitives, to fix the problem we have to use the method compareTo of 'comparable' interface
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    //A beautiful code ^^
    static <T extends Comparable<T>> int countGreatherThan(T[] arr, T elem) {
        int count = 0;
        for (T e : arr)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public static void main(String... args) {
        Integer[] arr = new Integer[] {3,6,8,9,2};
        int count = countGreatherThan(arr, 3);
        System.out.println("count >3:" + count);
    }
}