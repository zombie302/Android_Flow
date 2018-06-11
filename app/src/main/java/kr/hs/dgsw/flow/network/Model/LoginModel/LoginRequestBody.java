package kr.hs.dgsw.flow.network.Model.LoginModel;

public class LoginRequestBody {
    private String email;
    private String pw;

    public LoginRequestBody(String email, String pw) {
        this.email = email;
        this.pw = pw;
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
}
