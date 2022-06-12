package com.app.bgodriver.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.CarImage;
import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.CarInfo;
import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.Registration;


public class VehicleFragmentAdapter extends FragmentStateAdapter {

    public VehicleFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0)
        {
            return new CarInfo();
        }else if (position==1){
            return new CarImage();
        }else if (position==2){
            return new Registration();
        }
        return new CarInfo();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
