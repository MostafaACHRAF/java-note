package nestedClasses;

import java.util.function.Function;

public class DataStructure {
    
    // Create an array
    private final static int SIZE = 15;
    private static int[] arrayOfInts = new int[SIZE];
    
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
    
    public void printEven() {
        
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    interface DataStructureIterator extends java.util.Iterator<Integer> { } 

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
    
    private class EvenIterator implements DataStructureIterator {
        
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
        
        public boolean hasNext() {
            
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }        
        
        public Integer next() {
            
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }

    void print(DataStructureIterator iterator) {
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    void print(Function<Integer, Boolean> iterator) {
        for (Integer i : arrayOfInts) {
            if (iterator.apply(i)) {
                System.out.print(arrayOfInts[i] + " ");
            }
        }
        System.out.println();
    }

    static boolean isEvenIndex(int index) {
        return index % 2 == 0;
    }

    static boolean isOddIndex(int index) {
        return !isEvenIndex(index);
    }
    
    public static void main(String s[]) {
        
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();

        // Display odd numbers, using anonymous class
        ds.print(new DataStructureIterator() {
            private int nextIndex = 1;
            @Override public boolean hasNext() {return nextIndex <= SIZE - 1;}
            @Override public Integer next() {
                Integer value = arrayOfInts[nextIndex];
                nextIndex += 2;
                return value;
            }
        });

        ds.print(i -> i % 2 == 0);//print even numbers using Function
        ds.print(i -> i % 2 != 0);//print odd numbers

        //With method references
        ds.print(DataStructure::isEvenIndex);
        ds.print(DataStructure::isOddIndex);
        byte b = 6;
        double d = 8;
        b = (byte) d;
        Long l = (long)90;
        // int x = (int)l;
        System.out.println(String.valueOf(5.5));
        System.out.println("test" == "test");
        int x = (Integer)5;
    }
}