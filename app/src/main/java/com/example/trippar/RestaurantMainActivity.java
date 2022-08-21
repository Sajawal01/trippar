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

public class RestaurantMainActivity extends AppCompatActivity {

//    private Button btn_back;


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

    private ImageView imageView3;
    private TextView name3;
    private TextView location3;
    private TextView c_location3;
    private Button btn_call3;

    private ImageView imageView4;
    private TextView name4;
    private TextView location4;
    private TextView c_location4;
    private Button btn_call4;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);


//        btn_back = findViewById(R.id.btn_back_restaurant);

        restaurant1 = findViewById(R.id.restaurant1_layout_restaurant);
        imageView1 = findViewById(R.id.img1_restaurant);
        name1 = findViewById(R.id.name1_restaurant);
        location1 = findViewById(R.id.location1_restaurant);
        c_location1 = findViewById(R.id.c_location1_restaurant);
        btn_call1 = findViewById(R.id.btn2_restaurant);

        imageView2 = findViewById(R.id.img2_restaurant);
        name2 = findViewById(R.id.name2_restaurant);
        location2 = findViewById(R.id.location2_restaurant);
        c_location2 = findViewById(R.id.c_location2_restaurant);
        btn_call2 = findViewById(R.id.btn3_restaurant);

        imageView3 = findViewById(R.id.img3_restaurant);
        name3 = findViewById(R.id.name3_restaurant);
        location3 = findViewById(R.id.location3_restaurant);
        c_location3 = findViewById(R.id.c_location3_restaurant);
        btn_call3 = findViewById(R.id.btn4_restaurant);

        imageView4 = findViewById(R.id.img4_restaurant);
        name4 = findViewById(R.id.name4_restaurant);
        location4 = findViewById(R.id.location4_restaurant);
        c_location4 = findViewById(R.id.c_location4_restaurant);
        btn_call4 = findViewById(R.id.btn5_restaurant);


//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(RestaurantMainActivity.this, HomeFragment.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        restaurant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestaurantMainActivity.this, Restaurant1Activity.class);
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

        db.collection("restaurant").document("Gw3YKtvbn2gnYvzKBxF2").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant1")).into(imageView1);

                name1.setText(documentSnapshot.getString("name"));
                location1.setText(documentSnapshot.getString("location"));
                c_location1.setText(documentSnapshot.getString("c_location"));

            }
        });

        db.collection("restaurant").document("WKcEipewCj0ecSIHFsYr").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant2")).into(imageView2);

                name2.setText(documentSnapshot.getString("name"));
                location2.setText(documentSnapshot.getString("location"));
                c_location2.setText(documentSnapshot.getString("c_location"));

            }
        });

        db.collection("restaurant").document("7hL4SkYIEYxST9heX6Ti").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant3")).into(imageView3);

                name3.setText(documentSnapshot.getString("name"));
                location3.setText(documentSnapshot.getString("location"));
                c_location3.setText(documentSnapshot.getString("c_location"));

            }
        });

        db.collection("restaurant").document("Sv8WnpUpImuXzdcDL7Mv").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("restaurant4")).into(imageView4);

                name4.setText(documentSnapshot.getString("name"));
                location4.setText(documentSnapshot.getString("location"));
                c_location4.setText(documentSnapshot.getString("c_location"));

            }
        });

    }
}