package waiting;

public class WaitingState {
    public static void main(String... args) {
        Object obj = new Object();
        Runnable r = () -> {
            try {
                synchronized(obj) {
                    obj.wait();//makes the thread to wait against that object 'obj'. 'obj' is called a monitor object
                    //If you call 'wait' method outside a 'synchronized' block, you will get 'IllegalMonitorStateException' exception
                    //obj.wait(3000); //after 3 secondes even without getting notified the thread will resume and then stop.
                }
            } catch(InterruptedException e) {
                System.out.println("Error!");
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.setDaemon(true);
        t2.setDaemon(true);//set my threads to deamon so the program will stop even though that some threads may still be waiting. 
        t1.start();
        t2.start();

        System.out.println("#### Threads state while waiting:");
        System.out.println("t1: " + t1.getState());
        System.out.println("t2: " + t2.getState());

        synchronized(obj) {
            obj.notify();//a random thread will be notified. thus its state will change from 'waiting' to 'runnable' then 'terminated'
                        //If you call 'notify' method outside a 'synchronized' block, you will get 'IllegalMonitorStateException' exception
        }

        System.out.println("#### Threads state after notify:");
        System.out.println("t1: " + t1.getState());
        System.out.println("t2: " + t2.getState());

        //By default, threads in java are, 'user' threads, so the jvm won't shutdown if at least one 'user' thread is still running.
        //Because of 'notify' method one random thread will keep waiting. So the jvm won't stop
        //You have either use 'notifyAll' or 'wait(long timeout)' or set your threads to be 'daemon'

        System.out.println("#### Wait for a thread until he dies:");
        Runnable r2 = () -> {
            Thread t = Thread.currentThread();
            System.out.println(t.getId() + " - " + t.getName());
        };
        
        Thread t3 = new Thread(r2, "sasa1");
        Thread t4 = new Thread(r2, "sasa2");
        t3.start();
        try {
            t3.join();
            t4.start(); //t4 will start always after t3. Because of the method 'join' t4 will wait until t3 dies then start.
        } catch(InterruptedException e) {
            System.out.println("error!");
        }
        System.out.println("t3: " + t3.getState());
        System.out.println("t4: " + t4.getState());
    }
}