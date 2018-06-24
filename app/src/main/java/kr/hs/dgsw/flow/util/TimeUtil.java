package kr.hs.dgsw.flow.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public int getMonth(){
        SimpleDateFormat df = new SimpleDateFormat("MM");
        Date date = new Date();
        String month = df.format(date);
        return Integer.parseInt(month);
    }
    public int getToday(){
        SimpleDateFormat df = new SimpleDateFormat("dd");
        Date date = new Date();
        String today = df.format(date);
        return Integer.parseInt(today)-1;
    }
    public int getYear(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String year = df.format(date);
        return Integer.parseInt(year);
    }
    public int getNowHour(){
        SimpleDateFormat df = new SimpleDateFormat("HH");
        Date date = new Date();
        String hour = df.format(date);
        return Integer.parseInt(hour);
    }

    public int getHour(){
        SimpleDateFormat df = new SimpleDateFormat("HH");
        Date date = new Date();
        String hour = df.format(date);
        return Integer.parseInt(hour);
    }
    public int getMinute(){
        SimpleDateFormat df = new SimpleDateFormat("mm");
        Date date = new Date();
        String minute = df.format(date);
        return Integer.parseInt(minute);
    }

    public String getTimeToString(){
        int hour = getHour();
        int divHour = hour % 12;
        int minute = getMinute();
        if( divHour == 0) {
            if( hour/12 == 1){
                return 12 + " : " + Integer.toString(minute) + "PM";
            } else {
                return 12 + " : " + Integer.toString(minute) + "AM";
            }
        }
        if( hour/12 == 1){
            return Integer.toString(hour%12) + " : " + Integer.toString(minute) + "PM";
        } else {
            return Integer.toString(hour) + " : " + Integer.toString(minute) + "AM";
        }
    }

    public String getTimeToString(int hour, int minute){
        int divHour = hour % 12;
        if( divHour == 0) {
            if( hour/12 == 1){
                return 12 + " : " + Integer.toString(minute) + "PM";
            } else {
                return 12 + " : " + Integer.toString(minute) + "AM";
            }
        }
        if( hour/12 == 1){
            return Integer.toString(hour%12) + " : " + Integer.toString(minute) + "PM";
        } else {
            return Integer.toString(hour) + " : " + Integer.toString(minute) + "AM";
        }
    }
}
