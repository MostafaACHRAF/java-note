package locks;

public class MyVolatile {
    static class Some {
        int x;
        int y;
    }
    public static void main(String... args) {
        Some s = new Some();
        new Thread(() -> {
            while (s.y < 1) {
                System.out.println("y < 1");
                s.x += 10;
            }
        }).start();

        new Thread(() -> {
            s.x = 2;
            s.y = 2;
        }).start();

        //if the compiler decides to cache the object some, then this loop will be infinite because each thread will see its own version of 'x' and 'y'.
    }
}