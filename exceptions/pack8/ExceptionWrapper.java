package pack8;

import java.lang.Exception;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ExceptionWrapper {

    private static class CustomException extends Exception {
        public CustomException(String message, Exception e) {
            super(message, e);
        }
    } 

    private static void readFile(String fileName) throws CustomException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            final String firstLine = br.readLine();

        } catch(IOException e) {
            System.out.println("Oooops!");
            throw new CustomException("Failed to read the file: " + fileName, e);
        }
    }

    private static void doSomething() throws CustomException {
        try {
            System.out.println("do something here...");
            throw new CustomException("failed to do something!", null);
        } finally {
            System.out.println("finally block...");
        }
        //The finally block will be executed even before transfering the control to the calling method to handle the thrown exception
    }

    public static void main(String... args) {
        try {
            readFile("hail-to-the-king");
        } catch(CustomException e) {
            System.out.println(e.getMessage());
            Throwable cause = e.getCause();//you can get the cause (wrapped exception)
            System.out.println("Real cause: " + cause.getMessage());
        }

        try {
            doSomething();
        } catch(CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}