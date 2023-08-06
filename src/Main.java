import classes.*;

public class Main {
    public static void main(String[] args) {
        Library myLib = new Library();
        Book book1 = new Book("The First Book", "Auz", true);

//      myLib.addBook(book1);
        myLib.removeBook("e360d24e-7bbf-4380-b518-bc33e4d8c693");
    }

//    IMPORTANT STUFF:
//    1. JSON
//          https://www.geeksforgeeks.org/working-with-json-data-in-java/
//          https://www.tutorialspoint.com/how-to-write-create-a-json-file-using-java
}