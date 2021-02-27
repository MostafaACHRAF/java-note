package exceptions;

import java.io.FileNotFoundException;

public class BookReader {
    private class Book {
        private String id;
        private String title;
        public Book(String title) {
            this.title = title;
        }
    }
    public Book findBookByTitle(String title) throws FileNotFoundException {
        //search logic here...
        if (title.length() > 0) {
            return new Book(title);
        }
        throw new FileNotFoundException(String.format("Can't find book with id: %s", title));
    }
}