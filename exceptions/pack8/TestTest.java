package pack8;

import java.io.IOException;
import java.lang.RuntimeException;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.io.FileNotFoundException;

public class TestTest {
    public static void main(String... args) {
        try {
            throw new FileNotFoundException("ffff");
            //If you uncomment this line, you will get a compilation error: 'unreachable statement' // throw new IllegalArgumentException("Error");

        } catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException!");
        }
        // } catch (IOException e) {
        //     System.out.println("IOException!");
        // } //If you uncomment this block you will get a compilation error: 'unreachable catch block' 
        //Because there is a relation of subclassing between IOException and FileNotFoundException
        //If you reorder the order of the catch blocks by catching the child class first, you get a compilation error: FileNotFoundException already caught
    }


    //This code won't compile. This is a relation of subclassing between IllegalArgumentException and RuntimeException.
}