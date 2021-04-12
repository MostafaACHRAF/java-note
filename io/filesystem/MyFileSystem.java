package filesystem;

import java.nio.file.FileSystems;
import java.nio.file.FileSystem;

public class MyFileSystem {
    public static void main (String... args) {
        FileSystem fs = FileSystems.getDefault(); //get the default fileSystem of your os
        fs.getFileStores().forEach(s -> System.out.println(s.type() + ' ' + s.name())); // display the stores: in case of unix system => root. In case of windows => c:
        fs.getRootDirectories().forEach(d -> System.out.println(d));
        final String separator = fs.getSeparator();
        System.out.println("[File separator: " + separator + "]");
    }
}