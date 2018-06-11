package kr.hs.dgsw.flow.network.Model.LoginModel;

public class LoginResponseBody {
    private int status;
    private String message;
    private ResponseData data;

    public LoginResponseBody(){

    }

    public LoginResponseBody(int status, String message, ResponseData data) {
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

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }
}
