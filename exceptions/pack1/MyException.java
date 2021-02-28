package pack1;

import java.io.FileNotFoundException;

public class MyException {
    // A method can throw any exception type, even without writing the code that throws them!
    public void fun1() throws Throwable {}
    public void fun2() throws Exception {}
    public void fun3() throws RuntimeException {}
    public void fun4() throws Error {}
    public void fun5() throws FileNotFoundException {}

    // Compiles successfully, because the try block catch 'fileNotFoundException' and throw it in the same time
    public void fun6() {
        try {
            throw new FileNotFoundException("file not found");
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Compiles successfully, because 'RuntimeException' is unchecked exception, you don't have to handle 'unchecked' exceptions
    public void fun7() {
        try {
            throw new RuntimeException("noo...");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // This method won't compile because the try catch handle a checked exception 'fileNotFound' without throwing it, or calling a method that throw it!
    /*public void fun8() {
        try {
            System.out.println("Get file...");
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }*/
}