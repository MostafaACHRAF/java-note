package atomic;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

public class MyCopyOnWriteList {
    public static void main (String... args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<>(new ArrayList<>());

        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                list.add(String.valueOf(i));
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        //waiting for the two thread to complete
        t1.join();
        t2.join();
        t3.join();

        //You don't have to wrap up your iterator inside a 'synchronized' block like you would did with 'synchronizedList'
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("size:" + list.size());
    }
}