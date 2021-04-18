package thread;

public class MyThread {
    public static void main(String... args) {
        System.out.println("Run threads 2...");
        Runnable r = () -> {
            Thread t = Thread.currentThread();
            System.out.println("Hello this is thread: " + t + " - " + t.isAlive() + " - " + t.getState());
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}