package executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class FixedPoolWithSubmit {
    public static void main(String... args) {
        Callable task = () -> {
            Thread.sleep(3);
            System.out.println("Kiki 💩");
            return "Big💩";
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> result = executorService.submit(task);
        try {
            String value = result.get();
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        executorService.shutdownNow();
    }
}