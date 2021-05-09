package nestedClasses;

class A {
    int id = -1;
}

public class Shadowing extends A {
    int id = 0;

    class InnerClass {
        int id = 10;
        int get(int id) {
            System.out.println("id: " + id);
            System.out.println("this.id: " + this.id);
            System.out.println("Shadowing.this.id: " + Shadowing.this.id);
            System.out.println("Shadowing.super.id: " + Shadowing.super.id);
            return Integer.valueOf(0);//unboxing
        }
    }

    static class StaticClass {
        //main: will be considered as a normal static method. Not the enter point of the program.
        public static void main(String... args) {
            System.out.println("static nested class");
        }
    }

    public static void main(String... args) {
        InnerClass ic = new Shadowing().new InnerClass();
        ic.get(100);

        new StaticClass().main();
        StaticClass.main();
    }
}