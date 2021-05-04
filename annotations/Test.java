package annotations;

import java.util.List;

class A {
    void m1() {}
    void m2() {}
    static void m3(){}
    static void m4() {}
}

class B extends A {
    // static void m1() {}//won't compile because B.m1 doesn't override A.m1 because its static!
    void m1() {}
    void m2() {}
    // void m3() {}//won't compile because A.m3 is static. So B.m3 doesn't override A.m3. You cannot override a static method!
    static void m4() {}//compiles successfully. B.m4 hides A.m4
}

class AA {
    int m1(int a) { System.out.println("AA"); return 0;}
    int sum(int a, int b) {System.out.println("AA-sum"); return 0;}
    int m2() {return 0;}
    String get(List<String> list) {return "";}
}

class BB extends AA {
    //Overload super method
    Integer m1(Integer b) {System.out.println("BB"); return 0;}

    // Integer sum(int a, int b) {System.out.println("BB-sum"); return 0;}//won't compile. because Integer is not compatible with int, child's method can't override parent's method 

    int sum(Integer a, Integer b) {System.out.println("BB-sum"); return 0;}//overload super method

    @Override
    int sum(int a, int b) {return 0;}//override the super method

    // double m2() {return 0.0;}//won't compile, this method doesn't override the super method, nor overload it!

    // String get(List<Integer> list) {return "0";}//won't compile because this is not a valid overloading. Because after type erasure those methods will have the same method type paramter
}

class CC {
    void m1(int... arr) {System.out.println("var-arg");}
    void m1(Integer a, Integer b) {System.out.println("Integer-Integer");}
    void m1(long a, long b) {System.out.println("long-long");}
    void m1(float a, float b) {System.out.println("float-float");}
}

public class Test {
    static class Inner {
        static void m() {}//won't compile if the class not static. 'static is only allowed in constant variable declaration'
        static int i = 55;
    }
    //overloading method are differentiated by the number and the type of the the parameters passed to it, they may or may not have the same return type
    //if two method have the same parameters number and type, they won't compile

    public static void main(String... args) {
        BB bb = new BB();
        bb.m1(5);//AA
        bb.m1(Integer.valueOf(5));//BB

        CC cc = new CC();
        cc.m1(5, 5);//the jvm will look for a method that matches the given parameters, 
                    //if not found it will look for the method with the closest type paramter, 
                    //if not found it will look for boxing, 
                    //if not it will look for var-arg
                    //exact match > widening > boxing > var-arg
                    //print: long-long
        
        cc.m1(Integer.valueOf(1), Integer.valueOf(2));//Integer-Integer
        cc.m1(Long.valueOf(1), Long.valueOf(2));//long-long

    }

}