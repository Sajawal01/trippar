package com.example.trippar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Hotel1BookRoom1 extends AppCompatActivity {

    private Button btn_back;

    private EditText first_name;
    private EditText last_name;
    private EditText phone;
    private EditText email;
    private EditText checkIn_date;
    private EditText checkOut_date;
    private EditText adult;
    private EditText kid;
    private EditText country;
    private EditText province;
    private EditText city;
    private EditText message;

    private Button btn_book;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel1_book_room1);

        btn_back = findViewById(R.id.btn_back_room1_book);

        first_name = findViewById(R.id.fname_room1_book);
        last_name = findViewById(R.id.lname_room1_book);
        phone = findViewById(R.id.phone_room1_book);
        email = findViewById(R.id.email_room1_book);
        checkIn_date = findViewById(R.id.checkIn_date_room1_book);
        checkOut_date = findViewById(R.id.checkOut_date_room1_book);
        adult = findViewById(R.id.adult_room1_book);
        kid = findViewById(R.id.kid_room1_book);
        country = findViewById(R.id.country_room1_book);
        province = findViewById(R.id.province_room1_book);
        city = findViewById(R.id.city_room1_book);
        message = findViewById(R.id.message_room1_book);

        btn_book = findViewById(R.id.btn_book_room1_book);

        builder = new AlertDialog.Builder(this );

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotel1BookRoom1.this, Hotel1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate();
            }
        });

    }

    private void validate(){

        if(first_name.getText().toString().isEmpty()){
            first_name.setError("Please enter your first name");
        }
        else if(last_name.getText().toString().isEmpty()){
            last_name.setError("Please enter your last name");
        }
        else if(phone.getText().toString().isEmpty()){
            phone.setError("Please enter your phone number");
        }
        if(email.getText().toString().isEmpty()){
            email.setError("Please enter your email");
        }
        if(checkIn_date.getText().toString().isEmpty()){
            checkIn_date.setError("Please enter start date");
        }
        if(checkOut_date.getText().toString().isEmpty()){
            checkOut_date.setError("Please enter last date");
        }
        if(adult.getText().toString().isEmpty()){
            adult.setError("Please enter number of adults");
        }
        if(kid.getText().toString().isEmpty()){
            kid.setError("Please enter number of kids");
        }
        if(country.getText().toString().isEmpty()){
            country.setError("Please enter your country name");
        }
        if(province.getText().toString().isEmpty()){
            province.setError("Please enter your province name");
        }
        if(city.getText().toString().isEmpty()){
            city.setError("Please enter your city name");
        }
        if(message.getText().toString().isEmpty()){
            message.setError("Please enter your message");
        }
        else {
            authentication();
        }
    }

    private void authentication() {
        builder.setTitle("Alert!!").setMessage("Are you show you want to book this room?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(Hotel1BookRoom1.this, "Successfully you book this room", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Hotel1BookRoom1.this, Hotel1Activity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(Hotel1BookRoom1.this, "Ops you can't book this room ", Toast.LENGTH_SHORT).show();

                        dialogInterface.cancel();
                    }
                })
                .show();
    }

}