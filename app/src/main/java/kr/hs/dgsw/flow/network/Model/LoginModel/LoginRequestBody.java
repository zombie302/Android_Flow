package kr.hs.dgsw.flow.network.Model.LoginModel;

public class LoginRequestBody {
    private String email;
    private String pw;

    //firebase token
    private String registration_token;

    public LoginRequestBody(String email, String pw, String token) {
        this.email = email;
        this.pw = pw;
        this.registration_token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getToken() {
        return registration_token;
    }

    public void setToken(String token) {
        this.registration_token = token;
    }
}
