package mainstatic;

public class MyStatic {
    static int some = 0;
    public static void main(String... args) {
        System.out.println("some = " + some);
        if (some < 3) {
            some++;
            main(null);
        }
        System.out.println("Hello world!");
    }
}