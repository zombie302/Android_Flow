package kr.hs.dgsw.flow.util;

import java.util.regex.Pattern;

public class Validation {
    public boolean isDgswEmail(String email){
        String pattern = "^[a-zA-Z0-9]+@dgsw\\.hs\\.kr$";

        if(Pattern.matches(pattern, email)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isCheckPw(String pw){
        String pattern2 = "^(?=.*[a-zA-Z]+)(?=.*[!@#$%^*+=()]|.*[0-9]+).{8,16}$";

        if(Pattern.matches(pattern2, pw)){
            return true;
        } else {
            return false;
        }
    }
}
