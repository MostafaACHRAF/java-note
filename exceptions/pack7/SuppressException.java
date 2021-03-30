package pack7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.AutoCloseable;
import java.util.Arrays;
import java.lang.Throwable;

public class SuppressException {
    public static void readFile(String fileName) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String line = in.readLine();
        } catch(FileNotFoundException e) {
            System.out.println("Error! file not found");
        } catch(IOException e) {
            System.out.println("IO exception!");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch(IOException e) {
                System.out.println("Sever error!");
            }
        }
    }

    static class MyAutoCloseable implements AutoCloseable {
        String fileName;
        MyAutoCloseable(String fileName) {
            this.fileName = fileName;
        }
        void readLine() throws FileNotFoundException {
            System.out.println("Read line of " + fileName + "...");
            throw new FileNotFoundException("File not found! sorry T_T");
        }
        @Override
        public void close() throws IOException {
            System.out.println("Close the file...");
            throw new IOException("Close exception!");
        }
    }

    public static void compactReadFile(String file) {
        try (MyAutoCloseable in = new MyAutoCloseable(file);) {
            in.readLine();

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            //The problem with this approch "try with params (autocloseable)" is that the throwed exceptions by the close wont't be handled. We call them "suppressed exceptions"
            //The solution to this problem "suppressed exceptions" is the use of ".getSuppressed()" method, which returns an array of suppressed exceptions.
            System.out.println("Suppressed exceptions:");
            Throwable[] suppressedExceptions = e.getSuppressed();
            Arrays.stream(suppressedExceptions).forEach(System.out::println);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        //no need for the finally block
        //The compiler will call the close method automatically for us ^^. This is why this syntax is called autoCloseable
    }

    public static void main(String... args) {
        // readFile("hail-the-king.txt");
        compactReadFile("hail-to-the-king");
    }
}