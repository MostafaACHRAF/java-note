package rules;

interface A {
    default void m() {
        System.out.println("A:m");
    }
}

interface B {
    private static void bee() {}
    private void foo() {}
    default void m() {
        System.out.println("B:m");
    }
}

abstract class FooClass {
    public abstract void fofo();
    protected abstract void koko();
    abstract void dodo();
    // private abstract void lolo();//won't compile
}

class BeeClass extends FooClass {
    protected void koko() {
        System.out.println("koko");
    }
    public void fofo() {
        System.out.println("fofo");
    }
    void dodo() {
        System.out.println("dodo");
    }
}

//There is a conflict between A and B
//Rule3 wont' compile if it doesn't override the method m.
public class Rule3 implements A, B {
    public void m() {
        A.super.m();
        B.super.m();
        System.out.println("Rule3:m");
    }
    public static void main(String... args) {
        Rule3 rule3 = new Rule3();
        rule3.m();//prints: A:m \n B:m \n Rule3:m
    }
}