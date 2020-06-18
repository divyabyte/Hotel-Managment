package com.example.hotelmanagmentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    private static String dbName = "my_database";
    private static int dbVer = 1;
    Context ct;

    MyDatabase(Context ct)
    {
        super(ct,dbName,null,dbVer);
        this.ct = ct;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Toast.makeText(ct,"Add items",Toast.LENGTH_LONG).show();

        String s = "create table User " +
                "(name TEXT,mob integer,email TEXT UNIQUE,rooms integer,guests integer,check_in TEXT,check_out TEXT)";

        sqLiteDatabase.execSQL(s);
    }

    public void insertValues(String s1, long l,String s2,int l1, int l2,String s3,String s4){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name",s1);
        cv.put("mob",l);
        cv.put("email",s2);
        cv.put("rooms",l1);
        cv.put("guests",l2);
        cv.put("check_in",s3);
        cv.put("check_out",s4);

        db.insert("User",null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<String> ShowValues()
    {
        SQLiteDatabase db = getReadableDatabase();
        String s = "select * from User";
        Cursor cr = db.rawQuery(s, null);

        ArrayList<String> al = new ArrayList<>();

        while (cr.moveToNext())
        {
            String s1 = cr.getString(0);
            long l = cr.getLong(1);
            String s2 = cr.getString(2);
            int l1 = cr.getInt(3);
            int l2 = cr.getInt(4);
            String s3 = cr.getString(5);
            String s4 = cr.getString(6);

            String s5 = "\n" + " Name is : " + s1 + "\n Mobile No is : " + l + "\n Email is : "+ s2
                    + "\n No of Rooms : " + l1 + "\n No of guests : " + l2
                    + "\n Check_in Date : " + s3 + "\n Check_out Date" + s4 + "\n";
            al.add(s5);
        }

        return al;

    }

    public void doDelete(String s)
    {
        SQLiteDatabase db = getWritableDatabase();

        String where = "email = ?";

        String [] ss = {s};

        db.delete("User",where,ss);

        Toast.makeText(ct,"Deletion Completed",Toast.LENGTH_LONG).show();
    }



}
