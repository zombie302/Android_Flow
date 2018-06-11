package kr.hs.dgsw.flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.network.RequestHttpURLConnection;
import kr.hs.dgsw.flow.util.Validation;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }



    public void onClickSubmitBtn(View v) {
        TextView et_email = findViewById(R.id.et_email);
        TextView et_password = findViewById(R.id.et_password);
        TextView et_passwordconf = findViewById(R.id.et_password_conf);
        TextView et_name = findViewById(R.id.et_name);
        Spinner spinner_gender = findViewById(R.id.spinner_gender);
        TextView et_phonenum = findViewById(R.id.et_phonenum);
        Spinner spinner_class_idx = findViewById(R.id.spinner_class_idx);
        Spinner spinner_class_num = findViewById(R.id.spinner_class_num);

        Validation validation = new Validation();

        if(!validation.isCheckPw(et_password.getText().toString())){
            Toast.makeText(this, "비밀번호는 영어 대소문자 숫자 특수문자를 넣어 주세요", Toast.LENGTH_SHORT).show();
            return;
        } else if(!et_password.getText().toString().equals(et_passwordconf.getText().toString())){
            Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
            return;
        } else if(!validation.isDgswEmail(et_email.getText().toString())){
            Toast.makeText(this, "학교 이메일을 사용하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestHttpURLConnection rhu = new RequestHttpURLConnection();
        rhu.signup(
                et_email.getText().toString(),
                et_password.getText().toString(),
                et_name.getText().toString(),
                spinner_gender.getSelectedItem().toString(),
                et_phonenum.getText().toString(),
                spinner_class_idx.getSelectedItem().toString(),
                spinner_class_num.getSelectedItem().toString()
        );

        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
