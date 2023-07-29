package classes;

import java.util.UUID;

public class Book {
    String title, author, bookID;
    Boolean availability;
    Book(String title, String author, Boolean availability) {
        this.title = title;
        this.author = author;
        this.availability = availability;
        this.bookID = this.genID();
    }

    private String genID() {
        return UUID.randomUUID().toString();
    }

}
