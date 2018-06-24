package kr.hs.dgsw.flow.network.Model.GoOutModel;

public class GoOutResponseBody{
    private int status;
    private String message;
    private ResponseData data;

    public GoOutResponseBody(int status, String message, ResponseData responseData) {
        this.status = status;
        this.message = message;
        this.data = responseData;
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

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    public ResponseData getResponseData() {
        return data;
    }

    public void setResponseData(ResponseData responseData) {
        this.data = responseData;
    }
}
