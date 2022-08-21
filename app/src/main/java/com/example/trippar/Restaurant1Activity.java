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

public class Restaurant1Activity extends AppCompatActivity {

    private Button btn_back;
    private Button btn_call;

    private TextView textView1;
    private TextView textView2;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant1);

        btn_back = findViewById(R.id.btn_back_restaurant1);
        btn_call = findViewById(R.id.btnCall_restaurant1);

        textView1 = findViewById(R.id.ayash_restaurant1);
        textView2 = findViewById(R.id.services_restaurant1);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Restaurant1Activity.this, RestaurantMainActivity.class);
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

        db.collection("restaurant").document("Gw3YKtvbn2gnYvzKBxF2").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                textView1.setText(documentSnapshot.getString("intro"));
                textView2.setText(documentSnapshot.getString("services"));

            }
        });

    }
}