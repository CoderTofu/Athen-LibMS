package classes;

import org.json.simple.JSONObject;

import java.util.UUID;

public class Book {

    String title, author, bookID;
    Boolean availability;
    public Book(String title, String author, Boolean availability) {
        this.title = title;
        this.author = author;
        this.availability = availability;
        this.bookID = this.genID();
    }

    public JSONObject objectify() {
        JSONObject bookInfo = new JSONObject();
        bookInfo.put("title", this.title);
        bookInfo.put("author", this.author);
        bookInfo.put("availability", this.availability);
        bookInfo.put("bookID", this.bookID);
        return bookInfo;
    }

    private String genID() {
        return UUID.randomUUID().toString();
    }

}
