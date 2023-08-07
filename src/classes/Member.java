package classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.UUID;

public class Member {
    String fName, lName, address, conNumber, memID;
    JSONArray curBorrowing;

    public Member(String fName, String lName,  String address, String conNumber) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.conNumber = conNumber;
        this.curBorrowing = new JSONArray(); // Books that they are currently borrowing
        this.memID = this.genID();
    }

    private String genID() {
        return UUID.randomUUID().toString();
    }

    public JSONObject objectify() {
        JSONObject memInfo = new JSONObject();
        memInfo.put("fName", this.fName);
        memInfo.put("lName", this.lName);
        memInfo.put("address", this.address);
        memInfo.put("conNumber", this.conNumber);
        memInfo.put("memID", this.memID);
        memInfo.put("curBorrowing", curBorrowing);
        return memInfo;
    }
}
