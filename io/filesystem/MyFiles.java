package filesystem;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.time.Instant;
import java.nio.file.Path;
import java.io.IOException;

//A top level class/interface can have the default access modifier or public access modifier only. Otherwise a compilation error is thrown.
 class MyFiles {
    public static void main(String... args) {
        //there is a method to create directories: Files.createDirectories(Path.of("/users/test/file.txt"))
        //Files.nonExists(Path.of(".")): check if a file/folder exists. A similar method is 'exists'
        try {
            Path testFilePath = Path.of("test.log");
            Files.deleteIfExists(testFilePath);
            Files.createFile(testFilePath);
            Files.writeString(testFilePath, "Hello World! " + Instant.now());
            Files.lines(testFilePath, Charset.forName("UTF-8"))
                .forEach(s -> System.out.println(s));
            Files.createDirectory(Path.of("./root/img/datas")); //if you try to create folder and a subfolder at once you will get an exception: NoSuchFileException
            //If you try to create only one new folder no exceptions will be thrown.


            // Files.move(Path.of("symlinc"));
        } catch(IOException e) {
            System.out.println("Error!" + e);
            Path datasFolder = Path.of("./root/img/datas");
            System.out.println(datasFolder.resolve("../../"));
            try {
                // Files.createDirectories(Path.of("./root/img/datas/text/test"));
                Files.createDirectory(Path.of("./root"));//if the folder already exist, a IOException thrown!
            }
            catch(IOException e1) {
                System.out.println("Error");
            }
        }
    }
}