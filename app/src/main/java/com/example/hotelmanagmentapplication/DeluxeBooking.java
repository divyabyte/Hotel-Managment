package com.example.hotelmanagmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;

public class DeluxeBooking extends AppCompatActivity {

    EditText name,phone_no,email,no_of_rooms,no_of_guests,dateIn,dateOut;
    String username,mail,check_in,check_out,text;
    int rooms,guests;
    Long phoneNo;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deluxe_booking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.user);
        phone_no = findViewById(R.id.phoneCall);
        email = findViewById(R.id.email);
        no_of_rooms = findViewById(R.id.noOfRooms);
        no_of_guests = findViewById(R.id.noOfGuests);
        dateIn = findViewById(R.id.check_in);
        dateOut = findViewById(R.id.check_out);

    }

    public void DeluxeBooking(View view) {

        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);

        if(TextUtils.isEmpty(name.getText().toString())){
            name.setError("Name not to be empty");
            name.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(phone_no.getText().toString()))
        {
            phone_no.setError("Check Your Mobile No");
            phone_no.setFocusable(true);
            return;
        }
        if(phone_no.getText().toString().length()!=10)
        {
            phone_no.setError("Check Your Mobile No length");
            phone_no.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(email.getText().toString())){
            email.setError("Email not to be empty");
            email.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(no_of_rooms.getText().toString()))
        {
            no_of_rooms.setError("No of rooms not to be empty");
            no_of_rooms.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(no_of_guests.getText().toString())){
            no_of_guests.setError("No of guests not to be empty");
            no_of_guests.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(dateIn.getText().toString()))
        {
            dateIn.setError("Check-in Date shouldn't to be empty");
            dateIn.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(dateOut.getText().toString()))
        {
            dateOut.setError("Check-out Date shouldn't to be empty");
            dateOut.setFocusable(true);
            return;
        }
        if (!email.getText().toString().trim().matches(emailPattern)) {
            email.setError("Check your email address");
            email.setFocusable(true);
            return;
        }

        username = name.getText().toString();
        phoneNo = Long.parseLong(phone_no.getText().toString());
        mail = email.getText().toString();
        rooms = Integer.parseInt(no_of_rooms.getText().toString());
        check_in = dateIn.getText().toString();
        check_out = dateOut.getText().toString();
        guests = Integer.parseInt(no_of_guests.getText().toString());

        MyDatabase md = new MyDatabase(getApplicationContext());
        md.insertValues(username,phoneNo,mail,rooms,guests,check_in,check_out);
        finish();

        name.setText("");
        phone_no.setText("");
        email.setText("");
        no_of_guests.setText("");
        no_of_rooms.setText("");
        dateIn.setText("");
        dateOut.setText("");

        Intent i = new Intent(DeluxeBooking.this, BookingDone.class);
        startActivity(i);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
