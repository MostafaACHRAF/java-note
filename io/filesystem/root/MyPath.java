package root;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class MyPath {

    public static void main(String... args) {
        Path textFile = Path.of(".", "text.txt"); //you can use a one string param or 'var-arg' param
        Path imgPath = Path.of("img");
        Path parentFile = textFile.getParent();
        Path nullImageFile = parentFile.resolve("./img/null.jpg");
        Path noneImageFile = nullImageFile.resolveSibling("none.jpg");
        Path nullImageNormalizedFile = nullImageFile.normalize();
        Path textFileRelativePath = imgPath.relativize(textFile);

        System.out.println("textFile: " + textFile);
        System.out.println("imagePath: " + imgPath);
        System.out.println("parentFile: " + parentFile);
        System.out.println("nullImageFile: " + nullImageFile);
        System.out.println("noneImageFile: " + noneImageFile);
        System.out.println("nullImageNormalizedFile: " + nullImageNormalizedFile);
        System.out.println("relative path of 'textFile' from 'img' folder: " + textFileRelativePath);
        try {
            textFile.toRealPath(); //check if the file really exist
        } catch(IOException e) {
            System.out.println("Error!" + e.getMessage());
        }

        System.out.println("################################# Files");
        try {
            System.out.println("\nList folders and files into root folder: ");
            Files.list(Path.of(".")).forEach(f -> System.out.println(f));

            System.out.println("\nList images inside img folder: ");
            Files.walk(Path.of("./img"))
                .map(f -> f.toString())
                .filter(n -> n.endsWith("jpg"))
                .forEach(f -> System.out.println(f));

            System.out.println("\nCreate a symbolic link between 'text.txt' and 'null.jpg'...");
            Path virtualPath = Path.of("./symlinc");
            Files.deleteIfExists(virtualPath); //delete the symbolicLink if exists. To prevent a runtimeException 'FileAlreadyExistsException'
            Files.createSymbolicLink(virtualPath, nullImageFile);

            Path symlink = Files.readSymbolicLink(virtualPath);
            System.out.println("\nCreated symbolic link points on => " + symlink);
        } catch(IOException e) {
            System.out.println("Error2!" + e);
        }


    }
 }