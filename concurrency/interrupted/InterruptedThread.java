package interrupted;

public class InterruptedThread {
    public static void main(String... args) {

        Runnable r = () -> {
            Thread t = Thread.currentThread();
            // if the interrupt signal is sent at that stage => the while loop won't be executed and the thread will be terminated
            System.out.println("Initial state => " + t.getState());
            while(!t.isInterrupted()) {
                try {
                    Thread.sleep(1000); // if interrupt signal is received at that stage => the method 'sleep' will be interrupted and will throw and exception.
                } catch(InterruptedException e) {
                    System.out.println("Interrupted while sleeping!");
                    return;
                }
            }
            System.out.println("Finished! Thread state => " + t.getState());// This line won't be executed because the 'return' statement if there is an interruption

            //Note: If no 'interrupt' signal is received, then the thread will sleep for 1 second and exit.
        };

        Thread t = new Thread(r);
        t.start();
        try {
            t.sleep(100);//sleep a bit of time to enter the while loop and trigger 'InterruptedException'
        } catch(InterruptedException e) {
            System.out.println("Error!");
        }
        t.interrupt(); // send the interruption signal
        //Inside the runnable we handled what will happen if we receive the interrupt signal.
        //So the call to that method 'interrupt' won't be ignored as normally it would do.
        System.out.println("=>" + t.getState());

    }
}
