package pack4;

import java.io.FileNotFoundException;

public class Try {

    public static void main(String... args) throws FileNotFoundException {
        // Will compile successfully, because the code in 'try' block throw 'RuntimeException' (NullPointerException)
        try {
            String name = null;
            System.out.println(name.length());
        } finally {
            System.out.println("Finally block...");
        }
        
        //This block of code won't compile because it throws a 'checked' exception with declaring or handling it!
        try {
            String[] people = {"Mostafa"};
            System.out.println(people[5]);
            throw new FileNotFoundException();// this line won't compile. Unless the method main either 'throws the exception' or add 'catch' block
        } finally {
            System.out.println("Hey! its finally block...");
        }
    }
}