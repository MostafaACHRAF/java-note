package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// @Retention(RetentionPolicy.SOURCE)
// @Target(ElementType.TYPE)
@interface Author {
    // String by() default ""; //in class's declaration you can use: [@Author, @Author()]
    // String by(); //You must give a default value to 'by': [@Author(by="")]
    String by = "";
    public int i = 4; 
    String name() default by;
    //You can define a variable here and call a variety of methods.... But you won't be able to use it as a default value, because its not a constant!
    String value = new StringBuilder("sdsds").append(00000).toString();
}

@Author(name="sasa")
interface interface1 {
    String n = "".toLowerCase() + "n/a";
}

@Author()
public class Main {

    @Deprecated
    @Author()
    static void open() {
        System.out.println("main: open");
    }

    @Author static final int serialUID;//won't compile without initialization at 'static initializer block'

    // if you try to use a constructor here! It won't work! because you can't intialize final fields once they are declated

    //But it works in an intialized block
    //This block is invoked once
    static {
        System.out.println("static initializer block");
        serialUID = 5;
    }

    //This block is invoked each time we create a new instance of Main
    //Invoked before the constructor
    {
        System.out.println("initializer block");

    }

    public static void main(String... args) {
        System.out.println("Main...");
        Main m = new Main();
        Main m2 = new Main();
        m.open();
    }
}