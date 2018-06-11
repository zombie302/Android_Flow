package kr.hs.dgsw.flow.network.Model.RegisterModel;

public class RegisterRequestBody {

    private String email;

    private String pw;

    private String name;

    private String gender;

    private String mobile;

    private Integer class_idx;

    private Integer class_number;

    public RegisterRequestBody(String email, String pw, String name, String gender, String mobile, Integer class_idx, Integer class_number) {
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.mobile = mobile;
        this.class_idx = class_idx;
        this.class_number = class_number;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getClass_idx() {
        return class_idx;
    }

    public void setClass_idx(Integer class_idx) {
        this.class_idx = class_idx;
    }

    public Integer getClass_number() {
        return class_number;
    }

    public void setClass_number(Integer class_number) {
        this.class_number = class_number;
    }
}
