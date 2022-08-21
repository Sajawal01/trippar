package com.example.trippar.ui.SettingsFragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.example.trippar.EditProfileActivity;
import com.example.trippar.LoginActivity;
import com.example.trippar.R;
import com.example.trippar.Utils;
import com.example.trippar.databinding.FragmentSettingsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SettingsFragment extends Fragment {

    private ImageView imageView;
    private TextView textView1;

    private LinearLayout edit_profile;
    private LinearLayout logout;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseStorage storage;
    StorageReference storageReference;


    private Utils utils;


    private SettingsViewModel settingsViewModel;
    private FragmentSettingsBinding binding;


    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "http://api.weatherapi.com/v1/current.json?key=b32bc49831b44608a8291152220901&q=Sargodha&aqi=no";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        utils = new Utils(getContext());

        imageView = root.findViewById(R.id.img1);
        textView1 = root.findViewById(R.id.txt1_setting);

        edit_profile = root.findViewById(R.id.layout_editProfile);
        logout = root.findViewById(R.id.layout_logout);


        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();



        db.collection("student").document("E172YIMc8aZSdCHcnkT4").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //         glide.(context).load(data).into(view)
                Glide.with(getContext()).load(documentSnapshot.getString("profile")).into(imageView);
                textView1.setText(documentSnapshot.getString("user_name"));

            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.putToken("logout");
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(getActivity().getApplication(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}