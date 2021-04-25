package arrays;

interface A {
    default void m() {
        System.out.println("A");
    }
}

interface B {
    default void m() {
        System.out.println("B");
    }
}

interface C extends A,B {
    default void m() {
        System.out.println("C");
    }
}

public class MyInterface2 implements C , A, B {
    @Override
    public void m() {
        C.super.m();
        System.out.println("myclass");
    }
    public static void main(String... args) {
        MyInterface2 myclass = new MyInterface2();
        myclass.m();
    }
}