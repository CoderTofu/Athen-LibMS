import classes.*;

public class Main {
    public static void main(String[] args) {
//        new MyFrame();
        Library myLib = new Library();
        Book book1 = new Book("The First Book", "Auz", true);
        myLib.addBook(book1);
    }

//    IMPORTANT STUFF:
//    1. JSON
//          https://www.geeksforgeeks.org/working-with-json-data-in-java/
//          https://www.tutorialspoint.com/how-to-write-create-a-json-file-using-java
}