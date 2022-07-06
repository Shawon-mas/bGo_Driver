package com.app.bgodriver.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.CarImage;
import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.CarInfo;
import com.app.bgodriver.view.driverProfileUi.driverDocumentFragment.Registration;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver.DocumentsInfo;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver.LicenseInfo;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver.PersonalInfo;

public class AddDriverFragmentAdapter extends FragmentStateAdapter {

    public AddDriverFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new PersonalInfo();
        }else if (position==1){
            return new LicenseInfo();
        }else if (position==2){
            return new DocumentsInfo();
        }
        return new PersonalInfo();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
