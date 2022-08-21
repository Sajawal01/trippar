package com.example.trippar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

public class HunzaValleyActivity extends AppCompatActivity {

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

    private LinearLayout restaurant11;
    private ImageView imageView11;
    private TextView name11;
    private TextView location11;
    private TextView c_location11;
    private Button btn_call11;


    private ImageView imageView22;
    private TextView name22;
    private TextView location22;
    private TextView mail22;
    private TextView c_location22;
    private Button btn_call22;

    private ImageView imageView33;
    private TextView name33;
    private TextView location33;
    private TextView c_location33;
    private Button btn_call33;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunza_valley);

//        btn_back = findViewById(R.id.btn_back_hunza);
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


        restaurant11 = findViewById(R.id.restaurant1_layout_restaurant);
        imageView11 = findViewById(R.id.img1_restaurant);
        name11 = findViewById(R.id.name1_restaurant);
        location11 = findViewById(R.id.location1_restaurant);
        c_location11 = findViewById(R.id.c_location1_restaurant);
        btn_call11 = findViewById(R.id.btn2_restaurant);

        imageView22 = findViewById(R.id.img2_restaurant);
        name22 = findViewById(R.id.name2_restaurant);
        location22 = findViewById(R.id.location2_restaurant);
        c_location22 = findViewById(R.id.c_location2_restaurant);
        btn_call22 = findViewById(R.id.btn3_restaurant);

        imageView33 = findViewById(R.id.img3_restaurant);
        name33 = findViewById(R.id.name3_restaurant);
        location33 = findViewById(R.id.location3_restaurant);
        c_location33 = findViewById(R.id.c_location3_restaurant);
        btn_call33 = findViewById(R.id.btn4_restaurant);

//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HunzaValleyActivity.this, HomeFragment.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HunzaValleyActivity.this, WeatherUpdateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        hotel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HunzaValleyActivity.this, Hotel1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        db.collection("hotel").document("2CQlO9o61PU71X0CmJQp").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("hotel_1")).into(imageView1);

                name1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                c_location1.setText(documentSnapshot.getString("c_location"));
                phone1.setText(documentSnapshot.getString("phone"));

            }
        });

        db.collection("hotel").document("j8oGnqMiL55UBuquiJlY").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("hotel_2")).into(imageView2);

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


        restaurant11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HunzaValleyActivity.this, Restaurant1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_call11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03150747476"));
                startActivity(intent);
            }
        });

        db.collection("restaurant").document("Gw3YKtvbn2gnYvzKBxF2").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant1")).into(imageView11);

                name11.setText(documentSnapshot.getString("name"));
                location11.setText(documentSnapshot.getString("location"));
                c_location11.setText(documentSnapshot.getString("c_location"));

            }
        });

        db.collection("restaurant").document("WKcEipewCj0ecSIHFsYr").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant2")).into(imageView22);

                name22.setText(documentSnapshot.getString("name"));
                location22.setText(documentSnapshot.getString("location"));
                c_location22.setText(documentSnapshot.getString("c_location"));

            }
        });

        db.collection("restaurant").document("7hL4SkYIEYxST9heX6Ti").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant3")).into(imageView33);

                name33.setText(documentSnapshot.getString("name"));
                location33.setText(documentSnapshot.getString("location"));
                c_location33.setText(documentSnapshot.getString("c_location"));

            }
        });


    }
}