package nestedClasses;

public class OuterClass {
    static String staticOuterField = "static outer field";
    String outerField = "outer field";

    void doSomething() {
        System.out.println("outer class do something...");
    }

    // an inner class can extend the outer class
    class InnerClass extends OuterClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass extends OuterClass {
        StaticNestedClass() {System.out.println("Initialize new static nested class object...");}
        void accessMembers(OuterClass outerClassInstance) {
            // System.out.println(outerField);//won't compile, you can't access instance variable in a static context!

            //To use instance variables, to have to pass by object references:
            System.out.println(outerClassInstance.outerField);

            //static memebers can be accessed directly
            System.out.println(staticOuterField);
        }
    }

    public static void main(String... args) {
        StaticNestedClass staticNestedClass = new StaticNestedClass();
        staticNestedClass.accessMembers(new OuterClass());

        //won't compile. Invalid syntax, static nested classes are instantiated like a top-level class, using the 'new' operator
        // StaticNestedClass staticNestedClass2 = (new OuterClass()).new StaticNestedClass();
        // staticNestedClass2.accessMembers(new OuterClass());

        new OuterClass().new InnerClass().doSomething();//won't compile because this method isn't part of inner class defenition, though it can access it in its methods
        //The above code will work, if the inner-class extends the outer class.

        new StaticNestedClass().doSomething();//valid syntax
        new OuterClass.StaticNestedClass().doSomething();//valid syntax
    }
}