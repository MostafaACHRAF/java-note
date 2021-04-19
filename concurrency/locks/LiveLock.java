package locks;

public class LiveLock {
    private static class A {
        boolean isOver;
    }
    public static void main(String... args) {
        A a = new A();
        A b = new A();
        Runnable r1 = () -> {
            while(a.isOver) {
                System.out.println("running r1...");
            }
            b.isOver = true;
        };
        Runnable r2 = () -> {
            while(b.isOver) {
                System.out.println("running r2...");
            }
            a.isOver = true;
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        //Livelock occurs when the action of a thread is the response to the action of another thread
        //The action of t2 => a.isOver=true is a response to the action of t1 while(a.isOver)...
    }
}