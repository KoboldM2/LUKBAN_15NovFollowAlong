package com.lukban.a15novfollowalong;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname, section, id;
    DBHelper helper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);

        id = findViewById(R.id.etID);
        fname = findViewById(R.id.etFName);
        lname = findViewById(R.id.etLName);
        section = findViewById(R.id.etSection);

    }

    public void addMethod(View view) {
        String first = fname.getText().toString();
        String last = lname.getText().toString();
        String sec = section.getText().toString();
        helper.insert(first, last, sec);
    }

    public void moveFirst(View view) {
        cursor = helper.getRecords();
        cursor.moveToFirst();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }

    public void movePrevious(View view) {
        cursor = helper.getRecords();
        cursor.moveToPrevious();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }

    public void moveNext(View view) {
        cursor = helper.getRecords();
        cursor.moveToNext();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }

    public void moveLast(View view) {
        cursor = helper.getRecords();
        cursor.moveToLast();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }

}
