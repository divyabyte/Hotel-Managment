package com.example.hotelmanagmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookingDone extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deluxe_done);
    }

    public void GoToHome(View view) {

        Intent i = new Intent(BookingDone.this,MainActivity.class);
        startActivity(i);
    }
}
