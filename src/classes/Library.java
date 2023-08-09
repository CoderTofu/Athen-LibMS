package classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Library {

    String filePath = "data.json";
    FileReader fileReader;
    FileWriter fileWriter;
    JSONParser parser = new JSONParser();
    JSONObject data;
    JSONArray booksArr, memArr;
    public Library() {
//      Check if a data.json exists

        File file = new File(filePath);

        if (!file.exists()) {
            data = new JSONObject();
            booksArr = new JSONArray();
            memArr = new JSONArray();

            data.put("books", booksArr);
            data.put("members", memArr);
            updateData();
        } else {
            try {
                fileReader = new FileReader(filePath);
                data = (JSONObject) parser.parse(fileReader);
                booksArr = (JSONArray) data.get("books");
                memArr = (JSONArray) data.get("members");
            } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void updateData() {
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(data.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int indexSearch(JSONArray array, String ID) {
        Map<JSONArray, String> idKeyMap = new HashMap<>();
        idKeyMap.put(booksArr, "bookID");
        idKeyMap.put(memArr, "memID");

        String idKey = idKeyMap.get(array);

        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            String currentID = (String) obj.get(idKey);
            if (currentID.equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void addBook(Book book) {
        booksArr.add(book.objectify());
        updateData();
    }

    public void addMember(Member member) {
        memArr.add(member.objectify());
        updateData();
    }

    public void removeBook(String bookID) {
         int toDelete = indexSearch(booksArr, bookID);
         if (toDelete != -1) {
             booksArr.remove(toDelete);
             updateData();
         }
    }

    public void removeMember(String memID) {
        int toDelete = indexSearch(memArr, memID);
        if (toDelete != -1) {
            memArr.remove(toDelete);
            updateData();
        }
    }

    public void editBookTitle(String bookID, String newTitle) {
        int toEdit = indexSearch(booksArr, bookID);
        JSONObject obj = (JSONObject) booksArr.get(toEdit);
        if (toEdit != -1) {
            obj.put("title", newTitle);
            updateData();
        }
    }

    public void editBookAuthor(String bookID, String author) {
        int toEdit = indexSearch(booksArr, bookID);
        JSONObject obj = (JSONObject) booksArr.get(toEdit);
        if (toEdit != -1) {
            obj.put("author", author);
            updateData();
        }
    }

    public void editBookAvailability (String bookID) {
        int toEdit = indexSearch(booksArr, bookID);
        JSONObject obj = (JSONObject) booksArr.get(toEdit);
        if (toEdit != -1) {
            obj.put("availability", !(boolean) obj.get("availability"));
            updateData();
        }
    }

    public void editMemName(String memID, String fName, String lName) {
        int toEdit = indexSearch(memArr, memID);
        JSONObject obj = (JSONObject) memArr.get(toEdit);
        if (toEdit != -1) {
            obj.put("fName", fName);
            obj.put("lName", lName);
            updateData();
        }
    }

    public void editMemAddress(String memID, String address) {
        int toEdit = indexSearch(memArr, memID);
        JSONObject obj = (JSONObject) memArr.get(toEdit);
        if (toEdit != -1) {
            obj.put("address", address);
            updateData();
        }
    }

    public void editMemConNumber(String memID, String conNumber) {
        int toEdit = indexSearch(memArr, memID);
        JSONObject obj = (JSONObject) memArr.get(toEdit);
        if (toEdit != -1) {
            obj.put("conNumber", conNumber);
            updateData();
        }
    }

    public void borrowBook(String bookID, String memID) {
        // Look for the index of the books and members
        int bookIndex = indexSearch(booksArr, bookID);
        int memberIndex = indexSearch(memArr, memID);

        // Look for the book and member using index
        JSONObject book = (JSONObject) booksArr.get(bookIndex);
        JSONObject member = (JSONObject) memArr.get(memberIndex);

        // Check if book is available to borrow
        if (! (Boolean) book.get("availability")) {
            System.out.println("Book is not available");
            return;
        }

        // Information to add when a borrowing happens
        JSONObject memInfo = new JSONObject(); // To be added to the book
        JSONObject bookInfo = new JSONObject(); // To be added to an array in the member object

        // Create the additional objects for info
        memInfo.put("name", member.get("fName") + " " + member.get("lName"));
        memInfo.put("address", member.get("address"));
        memInfo.put("conNumber", member.get("conNumber"));
        memInfo.put("memID", member.get("memID"));

        bookInfo.put("title", book.get("title"));
        bookInfo.put("author", book.get("author"));
        bookInfo.put("bookID", book.get("memID"));

        // Update the book and member info
        JSONArray borrowing = (JSONArray) member.get("curBorrowing");
        borrowing.add(bookInfo);
        book.put("borrower", memInfo);
        editBookAvailability(bookID);
        updateData();
    }

    public void returnBook() {}
}
