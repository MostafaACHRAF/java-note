package pack6;

public class StackOverflowHandler {
    static void fun() {
        fun();
    }

    public static void main(String... args) {
        try {
            fun();
        } catch(StackOverflowError e) {
            System.out.println("StackOverflowError!");
        } finally {
            System.out.println("Exit 1");
        }
    }
}