package com.example.hotelmanagmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SeeBooking extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_booking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lv = findViewById(R.id.listView);

        MyDatabase md = new MyDatabase(getApplicationContext());
        ArrayList<String> al = md.ShowValues();
        ArrayAdapter<String> ad = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,al);

        lv.setAdapter(ad);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
