package scanner;

import java.util.Scanner;
import java.io.Console;
import java.io.PrintWriter;

public class MyScanner {
    public static void main(String... args) {
        // Scanner scanner = new Scanner(System.in);
        // String txt = null;

        // System.out.println("Type 'exit' to quit");
        // System.out.println("Type anything and then press 'enter'");

        // while(!"exit".equals(txt = (scanner.nextLine()))) {
        //     System.out.println("You typed: " + txt);
        // }

        Console console = System.console();
        if (console == null) {
            System.out.println("No console found!");
        }

        PrintWriter writer = console.writer();
        writer.println("Type 'exit' to quit");
        writer.println("Type something + enter to continue");
        String line = null;
        while(!"exit".equals(line = console.readLine())) {
            System.out.println("Line: " + line);
        }
    }
}