package nestedClasses;

public class Nested {

    static long serialUID = 1L;
    final String name = "OuterClass";

    class InnerClass {
        // static int serialUID = 0;//won't compile, because inner classes are instance members of instance objects
        InnerClass() {
            System.out.println("Inner classes have access to enclosing instance's members:");
            System.out.printf("name: %s, serialUID: %s%n", name, serialUID);

        }
    }

    public static void main(String... args) {
        System.out.println("Hey!");

        Nested outerClass = new Nested();
        Nested.InnerClass innerClass = outerClass.new InnerClass();//this is how we instansiate inner classe's objects
    }

}