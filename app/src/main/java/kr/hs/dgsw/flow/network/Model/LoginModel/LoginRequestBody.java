package kr.hs.dgsw.flow.network.Model.LoginModel;

public class LoginRequestBody {

    private String email;
    private String pw;
    private String registration_token;

    public LoginRequestBody(String email, String pw, String registration_token) {
        this.email = email;
        this.pw = pw;
        this.registration_token = registration_token;
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

    public String getRegistration_token() {
        return registration_token;
    }

    public void setRegistration_token(String registration_token) {
        this.registration_token = registration_token;
    }
}
