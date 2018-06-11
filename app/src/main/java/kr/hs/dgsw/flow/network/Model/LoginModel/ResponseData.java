package kr.hs.dgsw.flow.network.Model.LoginModel;

public class ResponseData {
    private String token;
    private ResponseUser user;

    public ResponseData(String token, ResponseUser user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResponseUser getUser() {
        return user;
    }

    public void setUser(ResponseUser user) {
        this.user = user;
    }
}
