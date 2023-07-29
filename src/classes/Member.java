package classes;

import java.util.UUID;

public class Member {
    String name, address, conNumber, memID;

    Member(String name, String address, String conNumber) {
        this.name = name;
        this.address = address;
        this.conNumber = conNumber;
        this.memID = this.genID();
    }

    private String genID() {
        return UUID.randomUUID().toString();
    }
}
