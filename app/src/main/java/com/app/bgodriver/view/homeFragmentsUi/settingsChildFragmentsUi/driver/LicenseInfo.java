package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.FragmentLicenseInfoBinding;


public class LicenseInfo extends Fragment {
      private FragmentLicenseInfoBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentLicenseInfoBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }
}