package com.example.trippar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ChatRoomActivity extends AppCompatActivity {

    TextView tvtWhat, tvDisclaimer;
    EditText etQName, etQuery;
    Button btnAsk, btnQimg, btnQSubmit;
    ImageView imgQuery;
    Boolean toggle = false;

    Uri fileKaPath;
    final int PICK_IMAGE_REQUEST = 71;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseStorage storage;
    StorageReference storageReference;

    RecyclerView rvHa;
//    ChatAdapter adapterHai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
    }
}