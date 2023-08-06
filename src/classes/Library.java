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
    public void addBook(Book book) {
        booksArr.add(book.objectify());
        updateData();
    }

    public void addMember(Member member) {
        memArr.add(member.objectify());
        updateData();
    }

    public void removeBook(String bookID) {
         int toDelete = -1;
         for (int i = 0; i < booksArr.size(); i++) {
             JSONObject obj = (JSONObject) booksArr.get(i);
             String currentBookID = (String) obj.get("bookID");

             if (currentBookID.equals(bookID)) {
                 toDelete = i;
                 break;
             }
         }
         if (toDelete != -1) {
             booksArr.remove(toDelete);
             updateData();
         }
    }

    public void removeMember(String memID) {
        int toDelete = -1;
        for (int i = 0; i < memArr.size(); i++) {
            JSONObject obj = (JSONObject) memArr.get(i);
            String currentMemberID = (String) obj.get("memID");

            if (currentMemberID.equals(memID)) {
                toDelete = i;
                break;
            }
        }
        if (toDelete != -1) {
            memArr.remove(toDelete);
            updateData();
        }
    }
}
