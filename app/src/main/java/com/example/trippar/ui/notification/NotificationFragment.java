package com.example.trippar.ui.notification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trippar.AdopterClass;
import com.example.trippar.ModelClass;
import com.example.trippar.R;
import com.example.trippar.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {

    private Utils utils;

    private RecyclerView rec_user;
    private List<ModelClass> list_Users ;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseStorage storage;
    StorageReference storageReference;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);


        rec_user= view.findViewById(R.id.rec_even);


        utils=new Utils(getContext());
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        list_Users = new ArrayList<>();
        rec_user.setHasFixedSize(true);
        rec_user.setLayoutManager(new LinearLayoutManager(getContext()));

        fetchNotifi(utils.getToken());



        return view;
    }
    private void fetchNotifi(String token){

        Toast.makeText(getContext(), "debug1", Toast.LENGTH_SHORT).show();

        db.collection("admin").document("uNGjg4so0Q2G8g06yfwr")// whereEqualTo("studentID",token)
                .collection("notification").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "debug2", Toast.LENGTH_SHORT).show();
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                //Toast.makeText(getContext(), document.getString("header"), Toast.LENGTH_SHORT).show();

                                ModelClass modelClass = new ModelClass(

                                        document.getString("image"),
                                        document.getString("header"),
                                        document.getString("desc"),
                                        document.getString("phone")
                                );


                                list_Users.add(modelClass);
                            }
                            //Toast.makeText(getContext(), "debug4", Toast.LENGTH_SHORT).show();
                            AdopterClass adapter_unNotify = new AdopterClass(list_Users,getActivity().getApplication().getApplicationContext());
                            rec_user.setAdapter(adapter_unNotify);

                        }
                        else {
                            Toast toast = Toast.makeText(
                                    getActivity().getApplicationContext(),"faild",Toast.LENGTH_SHORT
                            );

                        }
                    }
                });


    }

    //    private void setdata() {
//
//        ModelClass model_users1= new ModelClass(
//                "Sajawal Hussain",
//                "Mr. XYZ",
//                "Disc",
//                "923150747476"
//
//        );
//        list_Users.add(model_users1);
//
//
//        ModelClass model_users2= new ModelClass(
//                "M.Aliyan",
//                "Mr. abc",
//                "Discription",
//                "048345683"
//
//        );
//        list_Users.add(model_users2);
//
//        ModelClass model_users3= new ModelClass(
//                "Junaid Anwar",
//                "Mr. abc",
//                "Discription",
//                "048345683"
//
//        );
//        list_Users.add(model_users3);
//
//
//
//        AdopterClass adapter_users = new AdopterClass(list_Users, getActivity().getApplication().getApplicationContext());
//
//        rec_user.setAdapter(adapter_users);
//    }
}