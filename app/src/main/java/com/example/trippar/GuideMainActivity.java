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

public class GuideMainActivity extends AppCompatActivity {

//    private Button btn_back;

    private LinearLayout guider1;
    private ImageView imageView1;
    private TextView name1;
    private TextView location1;
    private TextView c_location1;
    private TextView language1;
    private Button btn_call1;

    private ImageView imageView2;
    private TextView name2;
    private TextView location2;
    private TextView c_location2;
    private TextView language2;
    private Button btn_call2;

    private ImageView imageView3;
    private TextView name3;
    private TextView location3;
    private TextView c_location3;
    private TextView language3;
    private Button btn_call3;

    private ImageView imageView4;
    private TextView name4;
    private TextView location4;
    private TextView c_location4;
    private TextView language4;
    private Button btn_call4;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_main);

//        btn_back = findViewById(R.id.btn_back_guide);

        guider1 = findViewById(R.id.guider1_layout_guide);
        imageView1 = findViewById(R.id.guider1_guide);
        name1 = findViewById(R.id.name1_guide);
        location1 = findViewById(R.id.location1_guide);
        c_location1 = findViewById(R.id.c_location1_guide);
        language1 = findViewById(R.id.language1_guide);
        btn_call1 = findViewById(R.id.btn1_guide);

        imageView2 = findViewById(R.id.guider2_guide);
        name2 = findViewById(R.id.name2_guide);
        location2 = findViewById(R.id.location2_guide);
        c_location2 = findViewById(R.id.c_location2_guide);
        language2 = findViewById(R.id.language2_guide);
        btn_call2 = findViewById(R.id.btn2_guide);

        imageView3 = findViewById(R.id.guider3_guide);
        name3 = findViewById(R.id.name3_guide);
        location3 = findViewById(R.id.location3_guide);
        c_location3 = findViewById(R.id.c_location3_guide);
        language3 = findViewById(R.id.language3_guide);
        btn_call3 = findViewById(R.id.btn3_guide);

        imageView4 = findViewById(R.id.guider4_guide);
        name4 = findViewById(R.id.name4_guide);
        location4 = findViewById(R.id.location4_guide);
        c_location4 = findViewById(R.id.c_location4_guide);
        language4 = findViewById(R.id.language4_guide);
        btn_call4 = findViewById(R.id.btn4_guide);

//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(GuideMainActivity.this, HomeFragment.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        guider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideMainActivity.this, Guider1Activity.class);
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

        btn_call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03150747476"));
                startActivity(intent);
            }
        });

        btn_call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03150747476"));
                startActivity(intent);
            }
        });

        btn_call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03150747476"));
                startActivity(intent);
            }
        });

        db.collection("guider").document("4nT0rra13kn3wp0Rslqh").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("guider1")).into(imageView1);

                name1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                c_location1.setText(documentSnapshot.getString("c_location"));
                language1.setText(documentSnapshot.getString("language"));

            }
        });

        db.collection("guider").document("PkIoOx3ypcGxecG8j6pY").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("guider2")).into(imageView2);

                name2.setText(documentSnapshot.getString("name"));
                location2.setText(documentSnapshot.getString("location"));
                c_location2.setText(documentSnapshot.getString("c_location"));
                language2.setText(documentSnapshot.getString("language"));

            }
        });

        db.collection("guider").document("hB6sh94ShxtH8HlrGd3T").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("guider3")).into(imageView3);

                name3.setText(documentSnapshot.getString("name"));
                location3.setText(documentSnapshot.getString("location"));
                c_location3.setText(documentSnapshot.getString("c_location"));
                language3.setText(documentSnapshot.getString("language"));

            }
        }); db.collection("guider").document("jLj85eeccPivx0Gaw6tk").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("guider4")).into(imageView4);

                name4.setText(documentSnapshot.getString("name"));
                location4.setText(documentSnapshot.getString("location"));
                c_location4.setText(documentSnapshot.getString("c_location"));
                language4.setText(documentSnapshot.getString("language"));

            }
        });

    }
}