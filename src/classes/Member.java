package classes;

import org.json.simple.JSONObject;

import java.util.UUID;

public class Member {
    String fName, lName, address, conNumber, memID;

    public Member(String fName, String lName,  String address, String conNumber) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.conNumber = conNumber;
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
        return memInfo;
    }
}
