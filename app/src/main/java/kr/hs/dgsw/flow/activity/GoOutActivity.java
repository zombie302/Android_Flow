package kr.hs.dgsw.flow.activity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kr.hs.dgsw.flow.GoOutInterface;
import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.network.Model.Databases;
import kr.hs.dgsw.flow.network.Model.GoOutModel.GoOutResponseBody;
import kr.hs.dgsw.flow.network.RequestHttpURLConnection;
import kr.hs.dgsw.flow.util.TimeUtil;

public class GoOutActivity extends AppCompatActivity implements GoOutInterface{

    TextView startTime;
    TextView endTime;
    TextView reason;
    TimeUtil timeUtil = new TimeUtil();
    Calendar startCalendar = Calendar.getInstance();
    Calendar endCalendar = Calendar.getInstance();
    Databases databases;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_out);

        databases = new Databases(this);
        reason = findViewById(R.id.reason);
        startTime = findViewById(R.id.start_out);
        startTime.setText(timeUtil.getTimeToString());
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(GoOutActivity.this, startListener, timeUtil.getHour(), timeUtil.getMinute(), false);
                dialog.show();
            }
        });

        endTime = findViewById(R.id.end_out);
        endTime.setText(timeUtil.getTimeToString());
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(GoOutActivity.this, endListener, timeUtil.getHour(), timeUtil.getMinute(), false);
                dialog.show();
            }
        });

        CalendarView calendarView = findViewById(R.id.goOutCalendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                startCalendar.set(year, month, day);
                endCalendar.set(year, month, day);
            }
        });

    }

    private TimePickerDialog.OnTimeSetListener startListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            TimeUtil timeUtil = new TimeUtil();
            Log.i("시간",  " " + hourOfDay+ " " + minute);
            startTime.setText(timeUtil.getTimeToString(hourOfDay, minute));
            startCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            startCalendar.set(Calendar.MINUTE, minute);
        }
    };

    private TimePickerDialog.OnTimeSetListener endListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            TimeUtil timeUtil = new TimeUtil();
            Log.i("시간",  " " + hourOfDay+ " " + minute);
            endTime.setText(timeUtil.getTimeToString(hourOfDay, minute));
            endCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            endCalendar.set(Calendar.MINUTE, minute);
        }
    };

    public void onClickGoOut(MenuItem item){
        RequestHttpURLConnection rhc = new RequestHttpURLConnection(this);
        Date startDate = startCalendar.getTime();
        Date endDate = endCalendar.getTime();
        String start = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(startDate);
        String end = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(endDate);

        rhc.goOut(start, end, reason.getText().toString(), this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_out, menu);
        return true;
    }

    @Override
    public void goOut(GoOutResponseBody responseBody) {
        if(responseBody.getStatus() == 200){
            Log.i("성공", responseBody.getMessage());
            databases.insertGoOut(responseBody.getResponseData().getResponseGoOut());
            /*Notification notification = new Notification(this);
            notification.makeNoti();*/
        } else {
            Log.i("실패 사유", responseBody.getMessage());
            Toast.makeText(this, "신청실패", Toast.LENGTH_SHORT).show();
        }
    }
}
