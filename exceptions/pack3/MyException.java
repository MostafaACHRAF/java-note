package pack3;

import java.util.Arrays;
import java.util.List;

public class MyException  {
    public static int getInt(List<Integer> data) {
        int val = 0;
        try {
            System.out.println("Read data...");
            val = data.get(9);
            return val;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: data has only: " + data.size() + " elements!");
            return val; // val will still be 0, even after executing the code at line 17. Because 'primitive' variable are passed by value not by reference
        } finally {
            val += 10;
            System.out.println("Modified val: " + val);
        }
    }

    public static Long getLong(List<Long> data, int position) {
        Long val = new Long(0);
        try {
            System.out.println("Search long value at position: " + position);
            return data.get(position);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not found!");
            return val;// still be 0, because val is a primitive variable. 
        } finally {
            val = new Long(11);
            System.out.println("Add 11 to val. Val = " + val);
        }
    }

    public static StringBuilder getStringBuilder() {
        StringBuilder str = new StringBuilder("12");
        try {
            String[] students = {"Harry", "Paul"};
            System.out.println(students[5]);
        } catch(Exception e) {
            System.out.println("About to return: " + str);
            return str; //will change because of line 46
        } finally {
            str.append("00000");//Because str is an obeject, the value of the referenced object will change.
            System.out.println("Return value is now: " + str);
        }
        return str;
    }


    public static void main(String... args) {
        int val = getInt(Arrays.asList(1, 3, 5, 6));// returns 0
        System.out.println(val);
        Long val2 = getLong(Arrays.asList(5L, 8L, 9L, 1L), 4);
        System.out.println(val2);
        System.out.println("Str: " + getStringBuilder());
    }
}