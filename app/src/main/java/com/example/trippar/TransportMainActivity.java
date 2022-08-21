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

public class TransportMainActivity extends AppCompatActivity {

//    private Button btn_back;

    private LinearLayout sajawal;
    private ImageView imageView1;
    private TextView name1;
    private TextView location1;
    private TextView mail1;
    private TextView phone1;

    private LinearLayout zeeshan;
    private ImageView imageView2;
    private TextView name2;
    private TextView location2;
    private TextView mail2;
    private TextView phone2;

    private LinearLayout khawar;
    private ImageView imageView3;
    private TextView name3;
    private TextView location3;
    private TextView mail3;
    private TextView phone3;

    private ImageView imageView4;
    private TextView name4;
    private TextView location4;
    private TextView mail4;
    private TextView phone4;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_main);

//        btn_back = findViewById(R.id.btn_back_transport);

        sajawal = findViewById(R.id.sajawal_layout_transport);
        imageView1 = findViewById(R.id.sajawal_transport);
        name1 = findViewById(R.id.name1_transport);
        location1 = findViewById(R.id.location1_transport);
        mail1 = findViewById(R.id.mail1_transport);
        phone1 = findViewById(R.id.phone1_transport);

        zeeshan = findViewById(R.id.zeeshan_layout_transport);
        imageView2 = findViewById(R.id.zeeshan_transport);
        name2 = findViewById(R.id.name2_transport);
        location2 = findViewById(R.id.location2_transport);
        mail2 = findViewById(R.id.mail2_transport);
        phone2 = findViewById(R.id.phone2_transport);

        khawar = findViewById(R.id.khawar_layout_transport);
        imageView3 = findViewById(R.id.khawar_transport);
        name3 = findViewById(R.id.name3_transport);
        location3 = findViewById(R.id.location3_transport);
        mail3 = findViewById(R.id.mail3_transport);
        phone3 = findViewById(R.id.phone3_transport);

        imageView4 = findViewById(R.id.qamar_transport);
        name4 = findViewById(R.id.name4_transport);
        location4 = findViewById(R.id.location4_transport);
        mail4 = findViewById(R.id.mail4_transport);
        phone4 = findViewById(R.id.phone4_transport);

//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TransportMainActivity.this, HomeFragment.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        sajawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransportMainActivity.this, Transporter1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        zeeshan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransportMainActivity.this, Transporter2Activity.class);
                startActivity(intent);
                finish();
            }
        });

        khawar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransportMainActivity.this, Transporter3Activity.class);
                startActivity(intent);
                finish();
            }
        });

        db.collection("driver").document("QcQsFBOz5e58nK782JqX").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("profile")).into(imageView1);

                name1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                mail1.setText(documentSnapshot.getString("mail"));
                phone1.setText(documentSnapshot.getString("phone"));

            }
        });

        db.collection("driver").document("7gv56dtckNSlZqHNjDiO").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("profile")).into(imageView2);

                name2.setText(documentSnapshot.getString("name"));
                location2.setText(documentSnapshot.getString("location"));
                mail2.setText(documentSnapshot.getString("mail"));
                phone2.setText(documentSnapshot.getString("phone"));

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

        db.collection("driver").document("tCC0VaOTYKyg3haL8y4z").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("profile")).into(imageView4);

                name4.setText(documentSnapshot.getString("name"));
                location4.setText(documentSnapshot.getString("location"));
                mail4.setText(documentSnapshot.getString("mail"));
                phone4.setText(documentSnapshot.getString("phone"));

            }
        });
    }
}