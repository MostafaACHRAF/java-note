package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAction {
    static class Some {
        // int x;
        AtomicInteger x = new AtomicInteger(0);
    }

    public static void main(String... args) {
        Some s = new Some();
        Runnable r = () -> {
            int y = 0;
            Thread t = Thread.currentThread();
            while (y < 10) {
                System.out.println(t + ":y: " + y);
                // y = ++(s.x);
                y = s.x.incrementAndGet();
            }
            System.out.println("x=" + s.x);
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
        System.out.println("x=>" + s.x);
    }
}