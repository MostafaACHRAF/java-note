package atomic;

import java.util.List;
import java.util.ArrayList;

public class ConcurrentList {
    public static void main(String... args) throws InterruptedException {
        List<String> elements = new ArrayList<>();

        Runnable r = () -> {
            Thread t = Thread.currentThread();
            System.out.println(t);
            for (int i = 0; i < 10; i++) {
                synchronized (elements) {
                    elements.add(String.format("(%s)", i));
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t3.join();

        elements.forEach(System.out::println);
        System.out.println("size=" + elements.size());

        // if you don't use the keyword 'synchronized' the size of the list will be stochastic.
        // because multiple threads may try to access the same index.
    }
}