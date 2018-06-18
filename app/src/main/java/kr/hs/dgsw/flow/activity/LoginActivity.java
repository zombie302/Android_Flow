package kr.hs.dgsw.flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kr.hs.dgsw.flow.LoginInterface;
import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.network.Model.Databases;
import kr.hs.dgsw.flow.network.Model.LoginModel.LoginResponseBody;
import kr.hs.dgsw.flow.network.RequestHttpURLConnection;

public class LoginActivity extends AppCompatActivity implements LoginInterface{

    Databases databases;
    EditText id;
    EditText pw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databases = new Databases(this);
        id = findViewById(R.id.login_id);
        pw = findViewById(R.id.login_pw);

    }

    public void onClickLoginBtn(View v){
        RequestHttpURLConnection rhc = new RequestHttpURLConnection();
        rhc.signin(id.getText().toString(), pw.getText().toString(), this);
    }

    @Override
    public void Login(LoginResponseBody loginResponseBody) {
        Log.i("loginTest", loginResponseBody.getMessage());
        if(loginResponseBody.getStatus() == 200){
            databases.insertToken(loginResponseBody.getData().getToken());
            Intent i = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "로그인에 실패함", Toast.LENGTH_SHORT).show();
        }
    }
}
