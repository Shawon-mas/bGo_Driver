package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.bgodriver.databinding.FragmentDocumentsInfoBinding;


public class DocumentsInfo extends Fragment {
    private FragmentDocumentsInfoBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentDocumentsInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}