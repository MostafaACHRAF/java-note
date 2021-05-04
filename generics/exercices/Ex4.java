package generics.exercices;

import java.lang.annotation.Documented;

public class Ex4 {
    @Documented
    @interface Weather {
        String description() default "";
        static final int humidity = 5;
    }

    static class Loader {
        static void load(int... arr) {
            System.out.println("int...");
        }

        static void load(int i1, int i2) {
            System.out.println("int i1, int i2");
        }

        static void load(long l1, long l2) {
            System.out.println("long l1, long l2");
        }
    }


    public static void main(String... args) {
        String s = 123 + "";//create a new string and put it into the string pool
        System.out.println("123" == s);
        System.out.println("123".equals(s));

        // var i = 1234;
        var str = "" + String.valueOf(1234);// or var str = "" + i;
        //The above two statements doesn't reference the string already placed in string pool. It creates a new one
        System.out.println("1234".equals(str));
        System.out.println("1234" == str);

        //###############################
        
        Loader.load(2, 4);//Expected: invoke int,int method 
    }

}