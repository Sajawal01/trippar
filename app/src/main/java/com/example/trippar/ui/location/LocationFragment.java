package com.example.trippar.ui.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trippar.GoogleMapActivity;
import com.example.trippar.R;
import com.example.trippar.databinding.FragmentDashboardBinding;

public class LocationFragment extends Fragment {

    private Button btn_map;


    private LocationViewModel locationViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        locationViewModel =
                new ViewModelProvider(this).get(LocationViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btn_map = root.findViewById(R.id.btn_dashboard);

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), GoogleMapActivity.class);
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