package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {
  private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentProfileBinding.inflate(inflater,container,false);
        implementTabLayout();

        return binding.getRoot();
    }

    private void implementTabLayout() {
        binding.profileTabLayout.addTab(binding.profileTabLayout.newTab().setText("Personal"));
        binding.profileTabLayout.addTab(binding.profileTabLayout.newTab().setText("Document"));
    }
}