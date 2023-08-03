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
            System.out.println("DOES NOT EXIST");

            data = new JSONObject();
            booksArr = new JSONArray();
            memArr = new JSONArray();

            data.put("books", booksArr);
            data.put("members", memArr);
            updateData();
        } else {
            System.out.println("EXISTS");

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
        data.put("books", booksArr);
        updateData();
    }


//    private void removeBook() {}
//    private void addMember() {}
//    private void removeMember() {}
}
