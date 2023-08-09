package classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            String currentID = (String) obj.get("bookID");

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

}
