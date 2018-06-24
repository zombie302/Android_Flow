package kr.hs.dgsw.flow.network.Model.NoticeModel;

public class NoticeResponse {
    private int status;
    private String message;
    private NoticeData data;

    public NoticeResponse(int status, String message, NoticeData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoticeData getData() {
        return data;
    }

    public void setData(NoticeData data) {
        this.data = data;
    }
}
