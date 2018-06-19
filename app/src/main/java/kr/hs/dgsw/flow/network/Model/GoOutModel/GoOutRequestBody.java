package kr.hs.dgsw.flow.network.Model.GoOutModel;

import java.sql.Timestamp;

public class GoOutRequestBody {
    private Timestamp start_time;
    private Timestamp end_time;
    private String reason;

    public GoOutRequestBody(Timestamp start_time, Timestamp end_time, String reason) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.reason = reason;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
