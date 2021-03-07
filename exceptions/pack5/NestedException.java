package pack5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NestedException {
    static FileInputStream fis;
    // the output is (because the inner catch didn't handle 'nullPointerException', that exception is propagated to the out 'try/catch' block):
    //Get players.txt...
    //Inner finally...
    //Null!
    //Outer finally...
    public static void main(String... args) {
        try {
            System.out.println("Get players.txt...");
            try {
                fis.close();
            } catch(IOException e) {
                System.out.println("IO exception!");
            } finally {
                System.out.println("Inner finally...");
            }
        } catch (NullPointerException e) {
            System.out.println("Null!");
        } finally {
            System.out.println("outer finally...");
        }
        // If you try to catch 'FileNotFoundException' you will get a compilation error 'Exception never thrown'
        // because we don't have a code that may throw that exception.
        // this rule apply for all checked exception.
    }
}