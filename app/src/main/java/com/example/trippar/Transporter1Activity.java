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
import com.example.trippar.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Transporter1Activity extends AppCompatActivity {

    private Button btn_back;

    private TextView transporter1;
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

    private ImageView bus_3;
    private TextView company3;
    private TextView model3;
    private TextView seat3;
    private Button btn3_book;

    private Button btncall;

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter1);

        btn_back = findViewById(R.id.btn_back_transporter1);

        transporter1 = findViewById(R.id.name1_transporter1);
        location1 = findViewById(R.id.location1_transporter1);
        description1 = findViewById(R.id.description1_transporter1);

        bus_1 = findViewById(R.id.bus_1_transporter1);
        company1 = findViewById(R.id.company1_transporter1);
        model1 = findViewById(R.id.model1_transport);
        seat1 = findViewById(R.id.seat1_transport);
        btn1_book = findViewById(R.id.btn1_transporter1);

        bus_2 = findViewById(R.id.bus2_transporter1);
        company2 = findViewById(R.id.company2_transporter1);
        model2 = findViewById(R.id.model2_transport);
        seat2 = findViewById(R.id.seat2_transport);
        btn2_book = findViewById(R.id.btn2_transporter1);

        bus_3 = findViewById(R.id.bus3_transporter1);
        company3 = findViewById(R.id.company3_transporter1);
        model3 = findViewById(R.id.model3_transport);
        seat3 = findViewById(R.id.seat3_transport);
        btn3_book = findViewById(R.id.btn3_transporter1);

        btncall = findViewById(R.id.btnCall_transporter1);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transporter1Activity.this, TransportMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn1_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transporter1Activity.this, Transporter1BookCar1.class);
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

        db.collection("driver").document("QcQsFBOz5e58nK782JqX").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                transporter1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                description1.setText(documentSnapshot.getString("description"));

            }
        });

        db.collection("transport").document("yP7cYmL1MQpc9xLpfDWJ").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("bus_1 url")).into(bus_1);

                company1.setText(documentSnapshot.getString("company"));
                model1.setText(documentSnapshot.getString("model"));
                seat1.setText(documentSnapshot.getString("seat"));

            }
        });

        db.collection("transport").document("yvaEoEtMCc6gW6Fy1Eav").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("bus_2")).into(bus_2);

                company2.setText(documentSnapshot.getString("company"));
                model2.setText(documentSnapshot.getString("model"));
                seat2.setText(documentSnapshot.getString("seat"));

            }
        });

        db.collection("transport").document("BUCa0gsimS2QP1ElOqFN").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Glide.with(getApplicationContext()).load(documentSnapshot.getString("bus_3")).into(bus_3);

                company3.setText(documentSnapshot.getString("company"));
                model3.setText(documentSnapshot.getString("model"));
                seat3.setText(documentSnapshot.getString("seat"));
            }
        });

    }
}