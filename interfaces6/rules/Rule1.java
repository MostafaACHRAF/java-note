package rules;

interface Readable {
    default void read(String s) {
        System.out.println("Readable: read " + s + "...");
    }
}

abstract class Reading {
    abstract void read(String s);
}

class Playing {
    public void read(String s) {
        System.out.println("Playing: read " + s + "...");
    }
}

public class Rule1 extends Playing implements Readable {
    // public void read(String s) {
    //     System.out.println("Rule1: read " + s);
    // }
    public static void main(String... args) {
        Rule1 rule1 = new Rule1();
        rule1.read("yes");//the method 'read' of the super class takes precedence over the default method 'read' of the interface.
        //The above rule applies even if the method defines an abstract method
    }
}