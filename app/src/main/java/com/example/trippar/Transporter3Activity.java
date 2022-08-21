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

public class Transporter3Activity extends AppCompatActivity {

    private Button btn_back;

    private TextView transporter3;
    private TextView location1;
    private TextView description1;

    private ImageView bus_1;
    private TextView company1;
    private TextView model1;
    private TextView seat1;
    private Button btn1_book;

    private ImageView bus_2;
    private TextView company2;
    private TextView model2;
    private TextView seat2;
    private Button btn2_book;

    private Button btncall;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter3);


        btn_back = findViewById(R.id.btn_back_transporter3);

        transporter3 = findViewById(R.id.name1_transporter3);
        location1 = findViewById(R.id.location1_transporter3);
        description1 = findViewById(R.id.description1_transporter3);

        bus_1 = findViewById(R.id.bus_5_transporter3);
        company1 = findViewById(R.id.company1_transporter3);
        model1 = findViewById(R.id.model1_transport3);
        seat1 = findViewById(R.id.seat1_transport3);
        btn1_book = findViewById(R.id.btn1_transporter3);

        bus_2 = findViewById(R.id.bus6_transporter3);
        company2 = findViewById(R.id.company2_transporter3);
        model2 = findViewById(R.id.model2_transport3);
        seat2 = findViewById(R.id.seat2_transport3);
        btn2_book = findViewById(R.id.btn2_transporter3);

        btncall = findViewById(R.id.btnCall_transporter3);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transporter3Activity.this, TransportMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn1_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transporter3Activity.this, Transporter1BookCar1.class);
                startActivity(intent);
                finish();
            }
        });

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03150747476"));
                startActivity(intent);
            }
        });

        db.collection("driver").document("moQVD2vzjGjq0wKwKRaC").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                transporter3.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                description1.setText(documentSnapshot.getString("description"));

            }
        });

        db.collection("transport").document("Zw0k3ASLFlmONtwxayvQ").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("bus5")).into(bus_1);

                company1.setText(documentSnapshot.getString("company"));
                model1.setText(documentSnapshot.getString("model"));
                seat1.setText(documentSnapshot.getString("seat"));

            }
        });

        db.collection("transport").document("qn8HgqVKOLqHeXzDwhEs").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("bus6")).into(bus_2);

                company2.setText(documentSnapshot.getString("company"));
                model2.setText(documentSnapshot.getString("model"));
                seat2.setText(documentSnapshot.getString("seat"));

            }
        });


    }
}