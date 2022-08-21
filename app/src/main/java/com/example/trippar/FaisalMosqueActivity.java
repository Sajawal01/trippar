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

public class FaisalMosqueActivity extends AppCompatActivity {

    private Button btn_back;
    private Button btn_weather;

    private LinearLayout khawar;
    private ImageView imageView3;
    private TextView name3;
    private TextView location3;
    private TextView mail3;
    private TextView phone3;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faisal_mosque);

        btn_back = findViewById(R.id.btn_back_faisal);
        btn_weather = findViewById(R.id.btn_weather_faisal);

        khawar = findViewById(R.id.khawar_layout_faisal);
        imageView3 = findViewById(R.id.khawar_faisal);
        name3 = findViewById(R.id.name_faisal);
        location3 = findViewById(R.id.location_faisal);
        mail3 = findViewById(R.id.mail_faisal);
        phone3 = findViewById(R.id.phone_faisal);

        btn_back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(FaisalMosqueActivity.this, HomeFragment.class);
               startActivity(intent);
               finish();
           }
       });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FaisalMosqueActivity.this, WeatherUpdateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        khawar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FaisalMosqueActivity.this, Transporter3Activity.class);
                startActivity(intent);
                finish();
            }
        });

        db.collection("driver").document("moQVD2vzjGjq0wKwKRaC").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
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