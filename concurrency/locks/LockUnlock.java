package locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;
import java.util.List;
import java.util.ArrayList;

public class LockUnlock {
    public static void main (String... args) throws InterruptedException {
        List<String> data = new ArrayList<>();

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock rl = rwl.readLock();//get read lock object
        Lock wl = rwl.writeLock();//get write lock object

        Runnable write = () -> {
            Thread t = Thread.currentThread();
            for (int i = 0; i < 5; i++) {
                wl.lock();
                data.add(String.format("%s:%s", t.getName(), "e"));
                wl.unlock();
            }
        };

        Runnable read = () -> {
            rl.lock();
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
            System.out.println("size =>" + data.size());
            rl.unlock();
        };

        Thread t1 = new Thread(write, "t1");
        Thread t2 = new Thread(write, "t2");
        Thread t3 = new Thread(write, "t3");
        Thread t4 = new Thread(read, "t4");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        t4.start();
        t4.join();
    }
}