package com.app.bgodriver.view.homeFragmentsUi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.bgodriver.R;
import com.app.bgodriver.adapter.SettingsAdapter;
import com.app.bgodriver.databinding.FragmentSettingBinding;
import com.app.bgodriver.model.SettingsModel;

import java.util.ArrayList;


public class Setting extends Fragment {
    private ArrayList<SettingsModel> settingsModels;
    private SettingsAdapter adapter;
    private FragmentSettingBinding binding;
    int[] images = {R.drawable.profile,
            R.drawable.home_profile,
            R.drawable.driver,
            R.drawable.vehicle,
            R.drawable.credit,
            R.drawable.help,
            R.drawable.logout};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentSettingBinding.inflate(inflater, container, false);
        implementRecyclerview();
        return binding.getRoot();
    }
//Profile
//Home
//Driver
//Vehicle
//Credit
//Help
//Logout
    private void implementRecyclerview() {
            binding.settingsRecycler.setHasFixedSize(true);
            binding.settingsRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            settingsModels=new ArrayList<>();
            settingsModels.add(new SettingsModel(images[0],"Profile"));
            settingsModels.add(new SettingsModel(images[1],"Home"));
            settingsModels.add(new SettingsModel(images[2],"Driver"));
            settingsModels.add(new SettingsModel(images[3],"Vehicle"));
            settingsModels.add(new SettingsModel(images[4],"Credit"));
            settingsModels.add(new SettingsModel(images[5],"Help"));
            settingsModels.add(new SettingsModel(images[6],"Logout"));
            adapter=new SettingsAdapter(getContext(),settingsModels);
            binding.settingsRecycler.setAdapter(adapter);


    }
}