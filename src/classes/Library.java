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
    FileReader fileReader;
    FileWriter fileWriter;
    JSONParser parser = new JSONParser();
    JSONObject data;
    JSONArray booksArr, memArr;
     public Library() {
//      Check if a data.json exists
        String filePath = "data.json"; //

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("DOES NOT EXIST");

            data = new JSONObject();
            booksArr = new JSONArray();
            memArr = new JSONArray();

            data.put("books", booksArr);
            data.put("members", memArr);
            try {
                fileWriter = new FileWriter(filePath);
                fileWriter.write(data.toJSONString());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("EXISTS");

            try {
                fileReader = new FileReader(filePath);
                data = (JSONObject) parser.parse(fileReader);
            } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void addBook() {
//        look for the book key
//        add a book as an object to the array
    }
    private void removeBook() {}
    private void addMember() {}
    private void removeMember() {}
}
