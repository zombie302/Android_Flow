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
}
