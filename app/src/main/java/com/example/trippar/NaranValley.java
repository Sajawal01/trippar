package com.example.trippar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.trippar.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class NaranValley extends AppCompatActivity {

//    private Button btn_back;
    private Button btn_weather;

    private LinearLayout hotel1;
    private ImageView imageView1;
    private TextView name1;
    private TextView location1;
    private TextView c_location1;
    private TextView phone1;

    private ImageView imageView2;
    private TextView name2;
    private TextView location2;
    private TextView c_location2;
    private TextView phone2;

    private ImageView imageView3;
    private TextView name3;
    private TextView location3;
    private TextView c_location3;
    private TextView phone3;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naran_valley);

//        btn_back = findViewById(R.id.btn_back_naran);
        btn_weather = findViewById(R.id.btn_weather_hunza);

        hotel1 = findViewById(R.id.hotel1_layout_hotelMain);
        imageView1 = findViewById(R.id.hotel1_hotelMain);
        name1 = findViewById(R.id.name1_hotelMain);
        location1 = findViewById(R.id.location1_hotelMain);
        c_location1 = findViewById(R.id.c_location1_hotelMain);
        phone1 = findViewById(R.id.phone1_hotelMain);

        imageView2 = findViewById(R.id.hotel2_hotelMain);
        name2 = findViewById(R.id.name2_hotelMain);
        location2 = findViewById(R.id.location2_hotelMain);
        c_location2 = findViewById(R.id.c_location2_hotelMain);
        phone2 = findViewById(R.id.phone2_hotelMain);

        imageView3 = findViewById(R.id.hotel3_hotelMain);
        name3 = findViewById(R.id.name3_hotelMain);
        location3 = findViewById(R.id.location3_hotelMain);
        c_location3 = findViewById(R.id.c_location3_hotelMain);
        phone3 = findViewById(R.id.phone3_hotelMain);

//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(NaranValley.this, HomeFragment.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NaranValley.this, WeatherUpdateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        hotel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NaranValley.this, Hotel2Activity.class);
                startActivity(intent);
                finish();
            }
        });


        db.collection("hotel").document("j8oGnqMiL55UBuquiJlY").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("hotel_2")).into(imageView1);

                name1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                c_location1.setText(documentSnapshot.getString("c_location"));
                phone1.setText(documentSnapshot.getString("phone"));

            }
        });

        db.collection("hotel").document("2CQlO9o61PU71X0CmJQp").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("hotel_1")).into(imageView2);

                name2.setText(documentSnapshot.getString("name"));
                location2.setText(documentSnapshot.getString("location"));
                c_location2.setText(documentSnapshot.getString("c_location"));
                phone2.setText(documentSnapshot.getString("phone"));

            }
        });

        db.collection("hotel").document("PNKUs3mHQf4BloD1FyvZ").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("hotel_3")).into(imageView3);

                name3.setText(documentSnapshot.getString("name"));
                location3.setText(documentSnapshot.getString("location"));
                c_location3.setText(documentSnapshot.getString("c_location"));
                phone3.setText(documentSnapshot.getString("phone"));

            }
        });

    }
}