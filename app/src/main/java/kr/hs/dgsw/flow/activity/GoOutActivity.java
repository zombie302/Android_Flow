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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.network.RequestHttpURLConnection;
import kr.hs.dgsw.flow.util.TimeUtil;

public class GoOutActivity extends AppCompatActivity{

    TextView startTime;
    TextView endTime;
    TimeUtil timeUtil = new TimeUtil();
    Calendar startCalendar = Calendar.getInstance();
    Calendar endCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_out);

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
        RequestHttpURLConnection rhc = new RequestHttpURLConnection();
        Date startDate = startCalendar.getTime();
        Date endDate = endCalendar.getTime();
        String start = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(startDate);
        String end = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(endDate);

        rhc.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_out, menu);
        return true;
    }
}
