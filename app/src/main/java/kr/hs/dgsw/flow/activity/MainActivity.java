package kr.hs.dgsw.flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import kr.hs.dgsw.flow.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnSikdan(View v){
        Intent intent= new Intent(MainActivity.this,SikdanActivity.class);
        startActivity(intent);
    }

    public void onClickBtnGoToRegister(View v){
        Intent intent= new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void onClickBtnGoToLogin(View v){
        Intent intent= new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
