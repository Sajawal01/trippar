package com.example.trippar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Guider1Activity extends AppCompatActivity {

    private Button btn_back;
    private Button btn_call;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guider1);

        btn_back = findViewById(R.id.btn_back_guider1);
        btn_call = findViewById(R.id.btnCall_guider1);

        textView1 = findViewById(R.id.intro_guider1);
        textView2 = findViewById(R.id.service1_guider1);
        textView3 = findViewById(R.id.service2_guider1);
        textView4 = findViewById(R.id.service3_guider1);
        textView5 = findViewById(R.id.service4_guider1);
        textView6 = findViewById(R.id.service5_guider1);
        textView7 = findViewById(R.id.expertise1_guider1);
        textView8 = findViewById(R.id.expertise2_guider1);
        textView9 = findViewById(R.id.expertise3_guider1);
        textView10 = findViewById(R.id.expertise4_guider1);
        textView11 = findViewById(R.id.expertise5_guider1);
        textView12 = findViewById(R.id.expertise6_guider1);
        textView13 = findViewById(R.id.expertise7_guider1);
        textView14 = findViewById(R.id.expertise8_guider1);
        textView15 = findViewById(R.id.expertise9_guider1);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Guider1Activity.this, GuideMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        db.collection("guider").document("4nT0rra13kn3wp0Rslqh").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                textView1.setText(documentSnapshot.getString("intro"));
                textView2.setText(documentSnapshot.getString("services1"));
                textView3.setText(documentSnapshot.getString("services2"));
                textView4.setText(documentSnapshot.getString("services3"));
                textView5.setText(documentSnapshot.getString("services4"));
                textView6.setText(documentSnapshot.getString("services5"));
                textView7.setText(documentSnapshot.getString("expertise1"));
                textView8.setText(documentSnapshot.getString("expertise2"));
                textView9.setText(documentSnapshot.getString("expertise3"));
                textView10.setText(documentSnapshot.getString("expertise4"));
                textView11.setText(documentSnapshot.getString("expertise5"));
                textView12.setText(documentSnapshot.getString("expertise6"));
                textView13.setText(documentSnapshot.getString("expertise7"));
                textView14.setText(documentSnapshot.getString("expertise8"));
                textView15.setText(documentSnapshot.getString("expertise9"));

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

    }
}