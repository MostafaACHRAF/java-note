package readwrite;

import java.io.Reader;
import java.io.Writer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;

public class Copy {

    private static void defaultCopier(String inputFileName, String outputFileName) {
        Charset utf8 = Charset.forName("UTF-8");
        try (Reader reader = new FileReader(inputFileName, utf8);
            Writer writer = new FileWriter(outputFileName, utf8);
        ) {
            System.out.println("Copy content of 'input.txt' to 'output.txt'...");
            char[] buffer = new char[1024];
            int length = 0;
            while((length = reader.read(buffer)) != -1) {
                System.out.println("Write a chunk of [1024] max...");
                writer.write(buffer, 0, length);
            }
        } catch(IOException e) {
            System.out.println("Ooops! something went wrong: " + e.getMessage());
        }
    }


    private static void advancedCopier(String inputFileName, String outputFileName) {
        Charset utf8 = Charset.forName("UTF-8");
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName), utf8));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), utf8));) {
            String line = null;
            
            while( (line = reader.readLine()) != null) {
                System.out.println("Write a new line...");
                writer.println(line);
            }

        } catch(IOException e) {
            System.out.println("Ooops! something went wrong: " + e.getMessage());
        }
    }

    public static void main(String... args) {
        //Using the new 'try' block syntax you don't have to write the 'finally' block for 'AutoCloseable' classes and call the 'close' method. All of that is done implicitly for you.
        advancedCopier("input.txt", "output.txt");
    } 
}