package kr.hs.dgsw.flow.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.network.Model.DatabaseTable.GoOutTable;
import kr.hs.dgsw.flow.network.Model.Databases;

public class GoOutAndSleepDocActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_out_and_sleep_doc);

        Databases databases = new Databases(this);

        GoOutTable goOutTable = databases.searchLastGoOut();

        TextView startTime = findViewById(R.id.textStartTime);
        TextView endTime = findViewById(R.id.textEndTime);
        TextView reason = findViewById(R.id.textReason);
        TextView email = findViewById(R.id.textEmail);

        startTime.setText(goOutTable.getStart_time());
        endTime.setText(goOutTable.getEnd_time());
        reason.setText(goOutTable.getReason());
        email.setText(goOutTable.getStudent_email());

    }
}
