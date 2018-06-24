package kr.hs.dgsw.flow.network.Model.GoOutModel;

public class GoOutRequestBody {
    private String start_time;
    private String end_time;
    private String reason;

    public GoOutRequestBody(String start_time, String end_time, String reason) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.reason = reason;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
