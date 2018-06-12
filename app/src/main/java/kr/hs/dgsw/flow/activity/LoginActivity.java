package kr.hs.dgsw.flow.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.network.Model.Databases;
import kr.hs.dgsw.flow.network.Model.LoginModel.LoginResponseBody;
import kr.hs.dgsw.flow.network.RequestHttpURLConnection;

public class LoginActivity extends AppCompatActivity{

    EditText id;
    EditText pw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id = findViewById(R.id.login_id);
        pw = findViewById(R.id.login_pw);

    }

    public void onClickLoginBtn(View v){
        RequestHttpURLConnection rhc = new RequestHttpURLConnection();
        LoginResponseBody loginResponseBody = rhc.signin(id.toString(), pw.toString());
        if(loginResponseBody.getStatus() == 200){
            Databases db = new Databases(this);
            db.insertToken(loginResponseBody.getData().getToken());
        } else {
            Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show();
        }
    }
}
