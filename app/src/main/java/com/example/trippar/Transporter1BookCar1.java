package com.example.trippar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trippar.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Transporter1BookCar1 extends AppCompatActivity {

    private Button btn_back;

    private EditText first_name;
    private EditText last_name;
    private EditText phone;
    private EditText email;
    private EditText start_date;
    private EditText end_date;
    private EditText adult;
    private EditText kid;
    private EditText country;
    private EditText province;
    private EditText city;
    private EditText message;

    private Button btn_book;

    AlertDialog.Builder builder;

    private Utils utils;
    private DocumentReference documentReference;


    private boolean isExist;

    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter1_book_car1);

        btn_back = findViewById(R.id.btn_back_transport1_book);

        first_name = findViewById(R.id.fname_transporter1_book);
        last_name = findViewById(R.id.lname_transporter1_book);
        phone = findViewById(R.id.phone_transporter1_book);
        email = findViewById(R.id.email_transporter1_book);
        start_date = findViewById(R.id.startdate_transporter1_book);
        end_date = findViewById(R.id.enddate_transporter1_book);
        adult = findViewById(R.id.adult_transporter1_book);
        kid = findViewById(R.id.kid_transporter1_book);
        country = findViewById(R.id.country_transporter1_book);
        province = findViewById(R.id.province_transporter1_book);
        city = findViewById(R.id.city_transporter1_book);
        message = findViewById(R.id.message_transporter1_book);

        btn_book = findViewById(R.id.btn_book_transporter1_book_car1);

        utils = new Utils(this);

        isExist = false;


        db = FirebaseFirestore.getInstance();
        utils = new Utils(this);
        isExist = false;


        builder = new AlertDialog.Builder(this );

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transporter1BookCar1.this, Transporter1Activity.class);
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
        if(start_date.getText().toString().isEmpty()){
            start_date.setError("Please enter start date");
        }
        if(end_date.getText().toString().isEmpty()){
            end_date.setError("Please enter last date");
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

        isExist = false;

        builder.setTitle("Alert!!").setMessage("Are you show you want to book this?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                db.collection("notification").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {

                                            if (isExist == false) {
                                                documentReference = db.collection("notification").document();

                                                String FirstName = first_name.getText().toString();
                                                String Email = email.getText().toString();
                                                String Phone = phone.getText().toString();
                                                String StartDate = start_date.getText().toString();
                                                String EndDate = start_date.getText().toString();
                                                String City = city.getText().toString();


                                                Map<String, String> userMap = new HashMap<>();
                                                userMap.put("email", Email);
                                                userMap.put("user_name", FirstName);
                                                userMap.put("phone", Phone);
                                                userMap.put("start_date", StartDate);
                                                userMap.put("end_date", EndDate);
                                                userMap.put("city", City);

                                                documentReference.set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {

                                                        Toast.makeText(Transporter1BookCar1.this, "Successfully you book this car", Toast.LENGTH_SHORT).show();

                                                        Intent intent = new Intent(Transporter1BookCar1.this, Transporter1Activity.class);
                                                        startActivity(intent);
                                                        finish();

                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {

                                                    }
                                                });

                                            }

                                        }

                                    }
                                });

//                                Toast.makeText(Transporter1BookCar1.this, "Successfully you book this car", Toast.LENGTH_SHORT).show();
//
//                                Intent intent = new Intent(Transporter1BookCar1.this, Transporter1Activity.class);
//                                startActivity(intent);
//                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(Transporter1BookCar1.this, "Ops you can't book this car ", Toast.LENGTH_SHORT).show();

                                dialogInterface.cancel();
                            }
                        })
                        .show();
    }
}