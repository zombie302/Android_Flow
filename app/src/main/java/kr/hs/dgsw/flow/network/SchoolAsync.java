package kr.hs.dgsw.flow.network;

import android.os.AsyncTask;

import org.hyunjun.school.School;
import org.hyunjun.school.SchoolException;
import org.hyunjun.school.SchoolMenu;

import java.util.List;

import kr.hs.dgsw.flow.SchoolMealI;

public class SchoolAsync extends AsyncTask{
    public SchoolMealI delegate = null;
    private List<SchoolMenu> menu;
    private int year;
    private int month;

    public SchoolAsync(int year, int month, SchoolMealI schoolMealI){
        delegate = schoolMealI;
        this.year = year;
        this.month = month;
    }

    @Override
    //[0] = year, [1] = month
    protected Object doInBackground(Object[] objects) {
        School api = new School(School.Type.HIGH, School.Region.DAEGU, "D100000282");

        try {
            menu = api.getMonthlyMenu(year, month);
        } catch (SchoolException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    protected void onPostExecute(Object o) {
        if(delegate != null)
        {
            delegate.setMeal(menu);
        }
    }
}
