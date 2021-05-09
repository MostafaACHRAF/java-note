package nestedClasses;

import java.util.Iterator;

public class EvenIteratorTest {
    private static final int SIZE = 15;
    private int[] intNumbers = new int[SIZE];

    interface I {}

    public EvenIteratorTest() {
        for (int i = 0; i < SIZE; i++) {
            intNumbers[i] = i;
        }
    }

    void printEvens() {
        EvenPrinter evenPrinter = new EvenPrinter();
        // EvenPrinter evenPrinter = this.new EvenPrinter();//will also compile
        while(evenPrinter.hasNext()) {
            System.out.print(evenPrinter.next() + " ");
        }
        System.out.println();
    }

    private interface EvenIterator extends Iterator<Integer> {}

    private class EvenPrinter implements EvenIterator, I {
        // interface I {}//won't compile because interfaces are static by inheritence, Also you can't define static members inside an inner class or local class
        private int index = 0;
        // private static final Integer i = -2;//won't compile because 'i' isn't a constant! Constants must be of type string or primitive and be static final.

        EvenPrinter() {}
        
        @Override
        public boolean hasNext() {
            return index <= SIZE - 1;
        }

        @Override
        public Integer next() {
            int value = intNumbers[index];
            index += 2;
            return value;
        }
    }


    public static void main(String... args) {
        EvenIteratorTest evenIteratorTest = new EvenIteratorTest();
        evenIteratorTest.printEvens();//0 2 4 6 8 10 12 14
    }
}