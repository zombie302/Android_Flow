package kr.hs.dgsw.flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import kr.hs.dgsw.flow.R;

public class NoticeDetailActivity extends AppCompatActivity {

    int idx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);
        Intent i = getIntent();
        idx = i.getIntExtra("idx", 0);
    }



}
