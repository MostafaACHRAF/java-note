package atomic;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MySynchronizedList {
    public static void main(String... args) throws InterruptedException {
        List<String> list = Collections.synchronizedList(new ArrayList<String>());

        Runnable r = () -> {
            for (int i = 0; i < 3; i++) {
                list.add(String.valueOf(i));//because of 'synchronizedList' no need to wrap up this method inside a 'synchronized' block.
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        //Despite the use of 'synchronizedList' the read methods are not thread-safe, a thread might read an inconsitent data
        //So you still have to use 'synchronized' block explicitly for read methods such as iterationg over list elements.
        //if comment the following 'synchronized' block you may get 'concurrentModificationException'
        synchronized (list) {
            Iterator iterator = list.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

        System.out.println("size:" + list.size());
    }
}