package kr.hs.dgsw.flow.network.Model;

public class FirebaseDataModel {
    String type;
    String idx;

    public FirebaseDataModel(String type, String idx) {
        this.type = type;
        this.idx = idx;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }



}
