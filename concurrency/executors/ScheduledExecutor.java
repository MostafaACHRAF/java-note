package executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class ScheduledExecutor {
    public static void main(String... args) {
        Runnable task = () -> {
            System.out.println("Hello! I'm a scheduled runnable logic called {KIKI}");
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);//create a thread pool of 3 threads. Those threads execution can be scheduled.
        scheduledExecutorService.scheduleAtFixedRate(task, 5, 3, TimeUnit.SECONDS);//execute task, each 3 secondes with an inital delay of 5 secondes
        ExecutorService executorService = Executors.unconfigurableExecutorService(scheduledExecutorService);//wrapp up our scheduledExecutor into an unconfigurable executor service to protect its configuration from future modifications.
        executorService.submit(task);//execute the executor service
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
            Thread.currentThread().interrupt();//propagate the interruption because maybe other threads in other levels doesn't aware of the interruption.
        }
        executorService.shutdownNow();//terminate the executor service now. After 10 seconds.
        System.out.println("Done!");
    }
}