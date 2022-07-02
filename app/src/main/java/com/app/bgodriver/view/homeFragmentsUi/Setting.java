package com.app.bgodriver.view.homeFragmentsUi;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.app.bgodriver.R;
import com.app.bgodriver.adapter.SettingsAdapter;
import com.app.bgodriver.databinding.FragmentSettingBinding;
import com.app.bgodriver.model.SettingsItemClick;
import com.app.bgodriver.model.SettingsModel;
import com.app.bgodriver.view.HomeActivity;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver.DriverList;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.profile.ProfileFragment;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.vehicle.Vehicle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class Setting extends Fragment implements SettingsItemClick {
    private ArrayList<SettingsModel> settingsModels;
    private ArrayList<SettingsModel> test;

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
            adapter=new SettingsAdapter(getContext(),settingsModels,this);
            binding.settingsRecycler.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {


        switch (position){
            case 0:
                Fragment fragment=new ProfileFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                transaction.replace(R.id.home_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 1:
                Toast.makeText(getContext(),"Position is:"+position,Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Fragment fragmentDriver=new DriverList();
                FragmentTransaction transactionDriver = getFragmentManager().beginTransaction();
                transactionDriver.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                transactionDriver.replace(R.id.home_container, fragmentDriver);
                transactionDriver.addToBackStack(null);
                transactionDriver.commit();
                break;
            case 3:
                Fragment fragmentVehicle=new Vehicle();
                FragmentTransaction transactionVehicle = getFragmentManager().beginTransaction();
                transactionVehicle.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                transactionVehicle.replace(R.id.home_container, fragmentVehicle);
                transactionVehicle.addToBackStack(null);
                transactionVehicle.commit();
                break;



        }

    }
}