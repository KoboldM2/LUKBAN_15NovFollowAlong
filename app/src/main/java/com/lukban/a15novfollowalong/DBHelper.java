package com.lukban.a15novfollowalong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    String col2 = "Fname";
    String col3 = "Lname";
    String col4 = "Section";
    String table = "stud";
    public DBHelper(@Nullable Context context) {
        super(context, "student.db", null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE stud ( ID INTEGER PRIMARY KEY AUTOINCREMENT , FName TEXT, LName TEXT, Section TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String fn, String ln, String sec) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2, fn);
        cv.put(col3, ln);
        cv.put(col4, sec);
        long isInserted = db.insert(table,null, cv);
        if(isInserted == -1) {
            //Toast.makeText(this,"failed to insert data", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            //Toast.makeText(this,"inserted data", Toast.LENGTH_LONG).show();
            return true;
        }
    }

    public Cursor getRecords() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectAll = "SELECT * FROM stud";
        return db.rawQuery(selectAll, null);
    }
}
