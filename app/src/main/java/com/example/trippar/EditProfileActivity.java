package com.example.trippar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.trippar.ui.SettingsFragment.SettingsFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EditProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button btn_chose;
    private Button btn_upload;

    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 22;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseStorage storage;
    StorageReference storageReference;

    private Utils utils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        utils = new Utils(this);

        imageView=findViewById(R.id.img1);
        textView=findViewById(R.id.text1_edit);
        btn_chose=findViewById(R.id.btn1);
        btn_upload=findViewById(R.id.btn2);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        btn_chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });


        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });


        db.collection("student").document("E172YIMc8aZSdCHcnkT4").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getApplicationContext()).load(documentSnapshot.getString("profile")).into(imageView);
                textView.setText(documentSnapshot.getString("user_name"));

            }
        });


    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }



    // UploadImage method
    private <lottiedialog> void uploadImage()
    {

        if (filePath != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog = new ProgressDialog(getApplication());
            progressDialog.setTitle("Uploading...");
//            progressDialog.show();




            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {

                                    Map<String,Object> m= new HashMap<>();
                                    m.put("profile",uri.toString());


                                    db.collection("student").document("E172YIMc8aZSdCHcnkT4").update(m)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(EditProfileActivity.this, SettingsFragment.class));
                                                    finish();
                                                    progressDialog.dismiss();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull  Exception e) {
//                                                    lottie.dismiss();
                                                    progressDialog.dismiss();
                                                    Toast.makeText(getApplicationContext(), "Connection Error", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                }
                            });



                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Connection Error", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            //Toast.makeText(ActivityNominee.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploading Data "+(int)progress+"%");
                        }
                    });
        }
    }

}