package com.app.bgodriver.view.driverProfileUi.driverProfileFragment;

import static com.app.bgodriver.utilites.Constants.KEY_LOCATION;
import static com.app.bgodriver.utilites.Constants.KEY_NAME;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.Settings;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.app.bgodriver.R;
import com.app.bgodriver.databinding.FragmentGeneralInfoBinding;
import com.app.bgodriver.model.FragmentToActivity;
import com.app.bgodriver.utilites.PreferenceManager;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.profile.ProfileFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class General_Info extends Fragment {

   private FragmentGeneralInfoBinding binding;

    private PreferenceManager preferenceManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentGeneralInfoBinding.inflate(inflater, container, false);

        preferenceManager=new PreferenceManager(getActivity());
        initViwes();
        clickListeners();


        return binding.getRoot();
    }

    private void initViwes() {

        binding.generalInfoName.setText(preferenceManager.getString(KEY_NAME));

    }

    private void clickListeners() {
        binding.generalInfoLocationMap.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(),MapActivity.class));
            onDestroy();

        });

            binding.generalInfoAddress.setText(getActivity().getIntent().getStringExtra(KEY_LOCATION));



    }





    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       /* SharedPreferences preferences = getActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        preferences.edit().putString("one",binding.generalInfoName.getText().toString()).apply();*/
        preferenceManager.putString(KEY_NAME,binding.generalInfoName.getText().toString());

    }
}