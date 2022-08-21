package com.example.trippar.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trippar.FaisalMosqueActivity;
import com.example.trippar.GuideMainActivity;
import com.example.trippar.HotelMainActivity;
import com.example.trippar.HunzaValleyActivity;
import com.example.trippar.MelaChiraghanActivity;
import com.example.trippar.MinarePakistanActivity;
import com.example.trippar.MurreeActivity;
import com.example.trippar.NaranValley;
import com.example.trippar.R;
import com.example.trippar.RestaurantMainActivity;
import com.example.trippar.TransportMainActivity;
import com.example.trippar.Utils;
import com.example.trippar.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private LinearLayout transport;
    private LinearLayout hotel;
    private LinearLayout restaurant;
    private LinearLayout guide;

    private CardView hunzaValley;
    private CardView naranValley;
    private CardView murree;
    private CardView faisal;
    private CardView melaChiraghan;
    private CardView minarePakistan;


    private Utils utils;

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        utils=new Utils(getContext());


        transport = root.findViewById(R.id.transport_home_1);
        hotel = root.findViewById(R.id.hotel_home_1);
        restaurant = root.findViewById(R.id.restaurant_home_1);
        guide = root.findViewById(R.id.guide_home_1);

        hunzaValley = root.findViewById(R.id.hunza_homefragment);
        naranValley = root.findViewById(R.id.naran_homefragment);
        murree = root.findViewById(R.id.murree_homefragment);
        faisal = root.findViewById(R.id.faisal_homefragment);
        melaChiraghan = root.findViewById(R.id.mela_chiraghan_homefragment);
        minarePakistan = root.findViewById(R.id.minarePakistan);

        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), TransportMainActivity.class);
                startActivity(intent);
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), HotelMainActivity.class);
                startActivity(intent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), RestaurantMainActivity.class);
                startActivity(intent);
            }
        });

        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), GuideMainActivity.class);
                startActivity(intent);
            }
        });

        hunzaValley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), HunzaValleyActivity.class);
                startActivity(intent);
            }
        });

        naranValley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), NaranValley.class);
                startActivity(intent);
            }
        });

        murree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), MurreeActivity.class);
                startActivity(intent);
            }
        });

        faisal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), FaisalMosqueActivity.class);
                startActivity(intent);
            }
        });


        melaChiraghan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), MelaChiraghanActivity.class);
                startActivity(intent);
            }
        });

        minarePakistan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), MinarePakistanActivity.class);
                startActivity(intent);
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