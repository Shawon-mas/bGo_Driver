package com.app.bgodriver.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.CarImage;
import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.CarInfo;
import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.Registration;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.vehicle.AddVehicle;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.vehicle.VehicleList;


public class SettingVehicleFragmentAdapter extends FragmentStateAdapter {

    public SettingVehicleFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0)
        {
            return new VehicleList();
        }else if (position==1){
            return new AddVehicle();
        }
        return new VehicleList();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
