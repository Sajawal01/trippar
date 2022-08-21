package com.example.trippar.ui.weather;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.trippar.EditProfileActivity;
import com.example.trippar.R;
import com.example.trippar.WeatherUpdateActivity;
import com.example.trippar.databinding.FragmentSettingsBinding;
import com.example.trippar.databinding.WeatherFragmentBinding;
import com.example.trippar.ui.SettingsFragment.SettingsViewModel;

public class WeatherFragment extends Fragment {
    private Button button;

//    private WeatherViewModel weatherViewModel;
//    private WeatherFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        View v = inflater.inflate(R.layout.weather_fragment, container, false);

        button = v.findViewById(R.id.btn_weather);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), WeatherUpdateActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}