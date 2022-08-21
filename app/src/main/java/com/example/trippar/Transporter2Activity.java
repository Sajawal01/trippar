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

public class Transporter2Activity extends AppCompatActivity {

    private Button btn_back;

    private TextView transporter1;
    private TextView location1;
    private TextView description1;

    private ImageView bus_1;
    private TextView company1;
    private TextView model1;
    private TextView seat1;
    private Button btn1_book;

    private Button btncall;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter2);

        btn_back = findViewById(R.id.btn_back_transporter2);

        transporter1 = findViewById(R.id.name1_transporter2);
        location1 = findViewById(R.id.location1_transporter2);
        description1 = findViewById(R.id.description1_transporter2);

        bus_1 = findViewById(R.id.bus_1_transporter2);
        company1 = findViewById(R.id.company1_transporter2);
        model1 = findViewById(R.id.model1_transporter2);
        seat1 = findViewById(R.id.seat1_transporter2);
        btn1_book = findViewById(R.id.btn1_transporter2);

        btncall = findViewById(R.id.btnCall_transporter2);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transporter2Activity.this, TransportMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn1_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transporter2Activity.this, Transporter1BookCar1.class);
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

        db.collection("driver").document("7gv56dtckNSlZqHNjDiO").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                transporter1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                description1.setText(documentSnapshot.getString("discription"));

            }
        });

        db.collection("transport").document("6GXrC0W3OkxYulyVJFKN").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("bus_4")).into(bus_1);

                company1.setText(documentSnapshot.getString("company"));
                model1.setText(documentSnapshot.getString("model"));
                seat1.setText(documentSnapshot.getString("seat"));

            }
        });

    }
}