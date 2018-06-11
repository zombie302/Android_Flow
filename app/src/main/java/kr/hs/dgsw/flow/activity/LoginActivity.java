package kr.hs.dgsw.flow.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import kr.hs.dgsw.flow.R;
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
        rhc.signin(id.toString(), pw.toString());
    }
}
