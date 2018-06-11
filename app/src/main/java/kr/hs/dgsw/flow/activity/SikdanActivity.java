package kr.hs.dgsw.flow.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;

import org.hyunjun.school.SchoolMenu;

import java.util.List;

import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.SchoolMealI;
import kr.hs.dgsw.flow.network.SchoolAsync;
import kr.hs.dgsw.flow.util.TimeUtil;

public class SikdanActivity extends AppCompatActivity implements SchoolMealI{
    List<SchoolMenu> schoolMenus = null;
    TextView meal;
    TextView textView;
    Spinner spinner;
    CalendarView calendarView;

    int today = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sikdan);
        meal = findViewById(R.id.meal);
        spinner = findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);
        calendarView = findViewById(R.id.calendarView);
        calendarView.setVisibility(View.GONE);
        getMonthlyMeal();

        CalendarView calendarView = (CalendarView)findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Log.d("date", "year : " + year + " month : " + month + " day : " + day);
                today = day;
                if(spinner.getSelectedItem().toString() == null){
                    meal.setText(schoolMenus.get(day-1).lunch);
                } else {
                    String when = spinner.getSelectedItem().toString();
                    switch (when) {
                        case "아침":
                            meal.setText(schoolMenus.get(day-1).breakfast);
                            break;
                        case "점심":
                            meal.setText(schoolMenus.get(day-1).lunch);
                            break;
                        case "저녁":
                            meal.setText(schoolMenus.get(day-1).dinner);
                            break;
                    }
                }
            }
        });

        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.sikdanArray));
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(today != 0){
                    switch (spinner.getItemAtPosition(i).toString()){
                        case "아침":
                            meal.setText(schoolMenus.get(today-1).breakfast);
                            break;
                        case "점심":
                            meal.setText(schoolMenus.get(today-1).lunch);
                            break;
                        case "저녁":
                            meal.setText(schoolMenus.get(today-1).dinner);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sikdan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.todaySikdan:
                spinner.setVisibility(View.GONE);
                calendarView.setVisibility(View.GONE);
                break;
            case R.id.otherDaySikdan:
                spinner.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.VISIBLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getMonthlyMeal(){
        TimeUtil timeUtil = new TimeUtil();
        int year = timeUtil.getYear();
        int month = timeUtil.getMonth();
        SchoolAsync schoolAsync = new SchoolAsync(year, month, this);
        schoolAsync.execute();
    }

    public void setSikdan(){
        TimeUtil timeUtil = new TimeUtil();
        int today = timeUtil.getToday();
        int hour = timeUtil.getNowHour();
        textView = findViewById(R.id.meal);
        if(hour < 7 && hour > 0){
            textView.setText(schoolMenus.get(today).breakfast);
        } else if( hour > 7 && hour <= 12){
            textView.setText(schoolMenus.get(today).lunch);
        } else if( hour >= 13 && hour <= 18){
            textView.setText(schoolMenus.get(today).dinner);
        } else {
            textView.setText(schoolMenus.get(today+1).breakfast);
        }
    }



    @Override
    public void setMeal(List<SchoolMenu> schoolMenu) {
        schoolMenus = schoolMenu;
        setSikdan();
    }
}
