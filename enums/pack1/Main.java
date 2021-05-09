package pack1;

import java.util.Arrays;

class A {
    A() {
        // this(0);
        // super();//this and super keyword can't coexist because, each one must be the first statement!
        this(0);
    }

    A(int a) {
        // this();//won't compile: Recursive constructor invocation
    }
    int a;
    void m1(int a) {}
}

class B extends A {
    // int m1(int b) {return 0;} //won't compile, this method doesn't overload, nor override parent's method

    int m1() {return 0;} //compile, this method overload parent's method

    @Override
    void m1(int b) {System.out.println("int...");}

    // @Override 
    // void m1(Integer a) {} //won't compile, this method overload parent's method

    void m1(Integer a) {System.out.println("Integer...");}
}

public class Main {
    public static void main(String... args) {
        // Planet p1 = Planet.EARTH;//won't compile: case sensible
        Planet p1 = Planet.Earth;
        Planet p2 = Planet.Mars;
        // Planet p3 = new Planet();//Won't compile: enums can't be instantiated
        
        System.out.println(p1 == p2);//false

        Arrays.stream(Planet.values()).forEach(p -> System.out.print(p + " "));

        double myWeightOnEarth =  args != null && args.length > 0 ? Double.parseDouble(args[0]) : 0;

        for (var u : Universe.values()) {
            System.out.printf("Your weight on %s is %f%n", u, u.surfaceWeight(myWeightOnEarth));
        }

        B b = new B();
        b.m1(5);//int...
        b.m1(Integer.valueOf(6));//Integer...
        b.m1((int)5.5);//int...
        // b.m1((Integer)6.6);//won't compile

        System.out.println(args.length);
        System.out.println(b.a);
    }
}