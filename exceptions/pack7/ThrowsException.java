package pack7;

import java.io.FileNotFoundException;
import java.io.IOException;

//You can continue to propagate exceptions till main method. The code will compile successfully.

public class ThrowsException {
    public static void readFile(String fileName) throws IOException {
        throw new FileNotFoundException(fileName + " : not found!");
    }
    public static void main(String... args) throws IOException {

        readFile("hail-to-the-king.txt");

    }
}