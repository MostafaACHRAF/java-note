package rules;

interface A {
    default void m() {
        System.out.println("A: m");
    }
}

interface B extends A {
    default void m() {
        System.out.println("B: m");
    }
}

//If B doesn't extend B, a compilation error will be thrown saying that A and B are incompatible
public class Rule2 implements A , B {
    public static void main(String args[]) {
        Rule2 rule2 = new Rule2();
        rule2.m();//A subtype interface default's method takes priority over a super-type interface default's method.
        //will return: B:m
    }
}