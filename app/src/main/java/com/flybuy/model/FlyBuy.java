package com.flybuy.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FlyBuy extends SQLiteOpenHelper {

    private static final String DB_NAME = "flybuy";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "cust_details";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String MOBILE_NO_COL = "mobile_no";
    private static final String EMAIL_COL = "email";
    private static final String TRAVELLER_PASSWORD = "tr_password";

    public FlyBuy(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + MOBILE_NO_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + TRAVELLER_PASSWORD + " TEXT)";
        db.execSQL(query);
    }

    public void addNewUser(String name, String mobile_no, String email, String tra_password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(MOBILE_NO_COL, mobile_no);
        values.put(EMAIL_COL, email);
        values.put(TRAVELLER_PASSWORD, tra_password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<String> getUserData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from cust_details where " + NAME_COL + "='" + id + "'", null );
        ArrayList <String> userD = new ArrayList<>();
        while(res.moveToNext()){
            userD.add(res.getString(1));
            userD.add(res.getString(2));
            userD.add(res.getString(3));
            userD.add(res.getString(4));
        }

        return userD;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
