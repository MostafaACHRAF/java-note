package arrays;

import java.util.Arrays;
import java.util.List;

public class MyArrays {
    static void print(char[] arr) {
        System.out.print("[");
        for (var elem : arr) {
            System.out.print(elem);
        }
        System.out.println("]:" + arr.length);
    }
    public static void main(String... args) {
        char[] c1 = {'a','b','c'};
        char[] c2 = new char[5];
        // c2[2] = 'v';//will be replaced by 'c'
        c2[3] = 'd';
        c2[4] = 'e';

        print(c1);
        print(c2);

        System.out.println("Copy c1 to c2...");
        
        System.arraycopy(c1, 0, c2, 0, 3);

        print(c1);
        print(c2);

        System.out.println("Create a copy of c1...");
        char[] c3 = Arrays.copyOf(c1, 5);//if the size of c1 is bigger than 5. than a bigger array is created
        print(c3);//[abc]

        char[] c4 = Arrays.copyOfRange(c3, 0, 2);
        print(c4);//[ab]// copy elements from 0 -> 1. 2 isn't included

        char[] c5 = Arrays.copyOfRange(c3, 1, 5);
        print(c5);//[bc]:4

        System.out.println("Fill c5...");
        Arrays.fill(c5, 3, 4, 'X');
        print(c5);//[XX]:2

        System.out.println("Sort c5...");
        Arrays.sort(c5);
        print(c5);

        String[] names = {"mostafa", "achraf", "rahaf", "fatima"};
        Arrays.sort(names);
        Arrays.stream(names).forEach(s -> System.out.print(s + " "));//default sort is alphabitic order

        System.out.println("\nSort names using a custom comparator...");
        Arrays.sort(names, (a, b) -> {
            return b.length() - a.length();
        });
        Arrays.stream(names).forEach(s -> System.out.print(s + " "));

        int sum = 0;
        for(int i = 0; i < 5; sum += i++);
        System.out.println("sum: " + sum);//9 => 0+1+2+3+4

    }
}