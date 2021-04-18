package synchronization;

public class MySynchronized {

    private static class Some {
        private static void sleep() {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Error!");
            }
        }

        public synchronized void doo() {
            sleep();
            System.out.println("Doo method.");// this instance method is synchronized against threads of the same object
        }
        public static synchronized void foo() {
            sleep();
            System.out.println("Foo method.");
        }
        public void koo() {
            System.out.println("Koo method.");
        }
    }

    public static void main(String... args) {
        System.out.println("##### Trying to access the same synchronized instance method");
        Some some = new Some();

        Runnable r = () -> {
            some.doo();
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        System.out.println("t1 state: " + t1.getState());//timed_waiting or blocked
        System.out.println("t2 state: " + t2.getState());//blocked or timed_waiting

        // t1.start();//You can't restart a terminated thread! IllegalThreadStateException is thrown.
        System.out.println("##### Trying to access the same static synchronized method");
        Runnable r2 = () -> {
            Some.foo();
        };
        Thread t3 = new Thread(r2);
        Thread t4 = new Thread(r2);
        t3.start();
        t4.start();
        System.out.println("t3 state: " + t3.getState());//timed_waiting or blocked or runnable
        System.out.println("t4 state: " + t4.getState());//blocked or timed_waiting or runnable

        System.out.println("##### Trying to access the same synchronized block");
        Runnable r3 = () -> {
            synchronized(some) {
                Some.sleep();
                some.koo();
            }
        };

        //one thread will be 'timed_waiting' and the other will be 'blocked'
        Thread t5 = new Thread(r3);
        Thread t6 = new Thread(r3);
        t5.start();
        t6.start();
        System.out.println("t5 state: " + t5.getState());
        System.out.println("t6 state: " + t6.getState());

    }
}