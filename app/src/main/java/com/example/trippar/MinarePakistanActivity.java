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

public class MinarePakistanActivity extends AppCompatActivity {

//    private Button btn_back;

    private Button btn_weather;

    private LinearLayout restaurant1;
    private ImageView imageView1;
    private TextView name1;
    private TextView location1;
    private TextView c_location1;
    private Button btn_call1;

    private ImageView imageView2;
    private TextView name2;
    private TextView location2;
    private TextView c_location2;
    private Button btn_call2;

    private LinearLayout zeeshan;
    private ImageView imageView3;
    private TextView name3;
    private TextView location3;
    private TextView mail3;
    private TextView phone3;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minare_pakistan);

//        btn_back= findViewById(R.id.btn_back_minar);

        btn_weather = findViewById(R.id.btn_weather_minarePakistan);

        restaurant1 = findViewById(R.id.restaurant1_layout_minarePakistan);
        imageView1 = findViewById(R.id.img1_mela);
        name1 = findViewById(R.id.name1_mela);
        location1 = findViewById(R.id.location1_mela);
        c_location1 = findViewById(R.id.c_location1_mela);
        btn_call1 = findViewById(R.id.btn2_mela);

        imageView2 = findViewById(R.id.img2_restaurant);
        name2 = findViewById(R.id.name2_restaurant);
        location2 = findViewById(R.id.location2_restaurant);
        c_location2 = findViewById(R.id.c_location2_restaurant);
        btn_call2 = findViewById(R.id.btn3_restaurant);

        zeeshan = findViewById(R.id.zeeshan_layout_minarePakistan);
        imageView3 = findViewById(R.id.zeeshan_transport);
        name3 = findViewById(R.id.name2_transport);
        location3 = findViewById(R.id.location2_transport);
        mail3 = findViewById(R.id.mail2_transport);
        phone3 = findViewById(R.id.phone2_transport);

//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MinarePakistanActivity.this, HomeFragment.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MinarePakistanActivity.this, WeatherUpdateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        restaurant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MinarePakistanActivity.this, Restaurant1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03150747476"));
                startActivity(intent);
            }
        });

        db.collection("restaurant").document("WKcEipewCj0ecSIHFsYr").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant2")).into(imageView1);

                name1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                c_location1.setText(documentSnapshot.getString("c_location"));

            }
        });

        db.collection("restaurant").document("Sv8WnpUpImuXzdcDL7Mv").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant4")).into(imageView2);

                name2.setText(documentSnapshot.getString("name"));
                location2.setText(documentSnapshot.getString("location"));
                c_location2.setText(documentSnapshot.getString("c_location"));

            }
        });

        zeeshan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MinarePakistanActivity.this, Transporter2Activity.class);
                startActivity(intent);
                finish();
            }
        });

        db.collection("driver").document("7gv56dtckNSlZqHNjDiO").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("profile")).into(imageView3);

                name3.setText(documentSnapshot.getString("name"));
                location3.setText(documentSnapshot.getString("location"));
                mail3.setText(documentSnapshot.getString("mail"));
                phone3.setText(documentSnapshot.getString("phone"));

            }
        });

    }
}