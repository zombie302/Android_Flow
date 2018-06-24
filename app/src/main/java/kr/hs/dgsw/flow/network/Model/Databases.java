package kr.hs.dgsw.flow.network.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import kr.hs.dgsw.flow.network.Model.DatabaseTable.GoOutTable;
import kr.hs.dgsw.flow.network.Model.DatabaseTable.TokenTable;
import kr.hs.dgsw.flow.network.Model.GoOutModel.ResponseGoOut;

public class Databases extends SQLiteOpenHelper {

    private static final String DB_NAME = "flow";
    private static final int DB_VERSION = 3;
    private static final String TABLE_TOKEN = "token_table";
    private static final String TABLE_GOOUT = "go_out_table";

    public Databases(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //토큰 테이블
        String sql1 = "create table " + TABLE_TOKEN + "(" +
                "idx integer primary key autoincrement," +
                "token varchar);";
        //외출 테이블
        String sql2 = "create table " + TABLE_GOOUT + "(" +
                "idx integer primary key autoincrement," +
                "accept integer," +
                "start_time varchar," +
                "end_time varchar," +
                "reason varchar," +
                "class_idx integer," +
                "student_email varchar" +
                ");";

        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql1 = "drop table "+ TABLE_TOKEN +";";
        String sql2 = "drop table " + TABLE_GOOUT + ";";
        db.execSQL(sql1);
        db.execSQL(sql2);
        onCreate(db);
    }

    public void insertToken(String token){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("token", token);
        db.insert(TABLE_TOKEN, null, values);
        db.close();
    }

    public TokenTable searchLastToken(){
        TokenTable tokenTable = new TokenTable();

        String sql = "SELECT * FROM " + TABLE_TOKEN;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToLast()){
            tokenTable.setIdx(cursor.getInt(0));
            tokenTable.setToken(cursor.getString(1));
        }
        return tokenTable;
    }

    public void insertGoOut(ResponseGoOut responseGoOut){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("accept", responseGoOut.getAccept());
        values.put("start_time", responseGoOut.getStart_time());
        values.put("end_time", responseGoOut.getEnd_time());
        values.put("reason", responseGoOut.getReason());
        values.put("class_idx", responseGoOut.getClass_idx());
        values.put("student_email", responseGoOut.getStudent_email());

        db.insert(TABLE_GOOUT, null, values);
        db.close();
    }

    public GoOutTable searchLastGoOut(){
        GoOutTable goOutTable = new GoOutTable();

        String sql = "SELECT * FROM " + TABLE_GOOUT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToLast()){
            goOutTable.setIdx(cursor.getInt(0));
            goOutTable.setAccept(cursor.getInt(1));
            goOutTable.setStart_time(cursor.getString(2));
            goOutTable.setEnd_time(cursor.getString(3));
            goOutTable.setReason(cursor.getString(4));
            goOutTable.setClass_idx(cursor.getInt(5));
            goOutTable.setStudent_email(cursor.getString(6));
        }
        return goOutTable;
    }
}
