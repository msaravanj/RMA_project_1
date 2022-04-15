package hr.msaravanj.projekt1rma;

import java.io.Serializable;

public class Holiday implements Serializable {

    private String localName;
    private String date;

    public Holiday(String name, String instructions) {
        this.localName = name;
        this.date = instructions;
    }


    public String getLocalName() {
        return localName;
    }

    public String getDate() {
        return date;
    }


    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
