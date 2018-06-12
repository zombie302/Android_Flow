package kr.hs.dgsw.flow.network.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import kr.hs.dgsw.flow.network.Model.DatabaseTable.TokenTable;

public class Databases extends SQLiteOpenHelper {

    private static final String DB_NAME = "flow";
    private static final int DB_VERSION = 1;
    private static final String TABLE_TOKEN = "token_table";

    public Databases(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE_TOKEN + "(" +
                "idx integer primary key autoincrement," +
                "token varchar);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table " + TABLE_TOKEN + ";";
        db.execSQL(sql);
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
}
