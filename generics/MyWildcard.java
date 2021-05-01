package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MyWildcard {
    static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            double dn = n.doubleValue();
            sum += dn;
        }
        return sum;
    }

    static void printList(List<?> list) {
        System.out.println();
        for (Object obj : list)
            System.out.print(obj);
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 4, 8, 4, 0, 5);
        List<Double> doubles = Arrays.asList(0.8, .0, 8.8, 5.9);

        int sumOfInts = (int) sumOfList(ints);
        double sumOfDoubles = sumOfList(doubles);

        System.out.println("sumOfInts= " + sumOfInts);
        System.out.println("sumOfDoubles= " + Math.round(sumOfDoubles));

        //#####################
        List<?> unboundedWildcardList = new ArrayList();//no warning! You can use <> diamond operator
        unboundedWildcardList.add(null);//ok
        // unboundedWildcardList.add(5);//won't compile, because you can only add null to List<?>
        //List<?> isn't like List<Object> where you can add any subtype of Object.

        printList(unboundedWildcardList);//printList can prints any list, because its has an unbounded wilcard type parameter; 
        //If you use List<Object> as a type parameter you won't be able to print Lists of integers,doubles,.... because these lists aren't subtypes of List<Object>
        printList(ints);
        printList(doubles);
    }
}