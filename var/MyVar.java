package var;

import java.util.List;
import java.util.function.Function;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class MyVar {

    static interface Jumpable {
        int some = 2344;
        default void live() {
            System.out.println("jumpable live");
        }
        static void sleep() {
            System.out.println("jumpable ZZZZZZZZZZ");
        }
    }
    static interface Writable {
        int some = 4555;
        default void live() {
            System.out.println("writable live");
        }
        int random();
    }
    static class MyClass implements Jumpable, Writable {
        public void live() {
            System.out.println("myclass live");
        }
        public int random() {
            return 0;
        }

        //var not allowed here
        // private var doo() {
        //     return "dd";
        // }

        //var not allowed here
        // private int foo(var x) {
        //     return x * 2;
        // }

    }

    public static void main (String... args) {
        // MyClass c = new MyClass();
        var c = new MyClass();//c will be of type MyClass, (inferred)
        var j = new Jumpable() {};//j will be inferred as Jumpable
        var w = new MyClass();//w will be inferred as myClass
        c.live();//calls myClass method's
        j.live();//calls jumpable method's
        w.live();//calls myClass method's
        Jumpable jump = new MyClass();
        System.out.println(j.some);//valid! you can access interface's static constants using instance reference object of type interface.
        System.out.println(jump.some);//valid though jump is referencing an object of type MyClass, but constants are binding according to variables type, not the type of the referenced object. 
        Jumpable.sleep();

        List<String> data = List.of("a", "b", "c", "d");

        for (var var : data) {//var is not a reserved keyword, thus you can name your variables 'var'
            System.out.println(var);
        }

        var names = new String[]{"mostafa", "achraf"};

        for (var name : names) {
            System.out.println(name);
        }

        Writable x = () -> 12;

        var action = (Function<Integer, Integer> & Serializable) i -> i + 1;

        // var nil = null; //initialization with null isn't allowed

        // var y,k = 0;//var not allowed here

        var kk = 0x7fff;
        System.out.println(kk);
        var gg = 0.5;//is inferred as a double
        var cc = 9.6f;//is inferred as a float
        var l = new ArrayList<>();//inferred as an 'ArrayList<Object>' of objects, not a List!
        var ll = new ArrayList<String>();//infered as an 'ArrayList<String>' of strings.

        Consumer<String> consumer = (var s) -> System.out.println(s);//valid
        data.forEach(consumer);
        // Consumer<String> c1 = var s -> System.out.println(s);//not valid
        // Consumer<String> c2 = String s -> System.out.println(s);//not valid
        // BiConsumer<String, String> c3 = (var s1, s2) -> System.out.println(s1 + s2);//not valid
        // BiConsumer<String, Integer> c4 = (var i, final var j) -> System.out.println(i + j);//you can't use variables already defined as lampda expression parameter name
        // BiConsumer<String, Integer> c4 = (var a, final b) -> System.out.println(a + b);//not valid

        final var xy = 0;
        
    }
}