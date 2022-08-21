package com.example.trippar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Hotel4Activity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    private Button btn_back;

    private Button btn1;
    private Button btn2;
    private Button btn3;

    private Button btn_call;

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel4);

        textView1 = findViewById(R.id.elites_hotel1);
        textView2 = findViewById(R.id.service1_hotel1);
        textView3 = findViewById(R.id.service2_hotel1);

        imageView1 = findViewById(R.id.img1_hotel1);
        imageView2 = findViewById(R.id.img2_hotel1);
        imageView3 = findViewById(R.id.img3_hotel1);

        btn_back = findViewById(R.id.btn_back_hotel4);

        btn1 = findViewById(R.id.btn1_hotel1);
        btn2 = findViewById(R.id.btn2_hotel1);
        btn3 = findViewById(R.id.btn3_hotel1);

        btn_call = findViewById(R.id.btnCall_hotel1);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotel4Activity.this, HotelMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotel4Activity.this, Hotel1BookRoom1.class);
                startActivity(intent);
                finish();
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03150747476"));
                startActivity(intent);
            }
        });

        db.collection("hotel").document("7Pyb86UeV5wQ8vRFjfgv").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                textView1.setText(documentSnapshot.getString("grace crown"));
                textView2.setText(documentSnapshot.getString("sercvices"));


            }
        });

        db.collection("room").document("OpC6ezjiUpzXGQCX14mG").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("room1")).into(imageView1);

            }
        });

        db.collection("room").document("Q0AP2ZilpynLvUEsXBra").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("room2")).into(imageView2);

            }
        });

        db.collection("room").document("OPGIvr2ir55bpwdMa2X7").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("room3")).into(imageView3);

            }
        });

    }
}