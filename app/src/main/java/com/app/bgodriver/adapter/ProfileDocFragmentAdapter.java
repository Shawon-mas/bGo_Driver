package com.app.bgodriver.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.General_Info;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.Nid_Info;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.SelfieInfo;

public class ProfileDocFragmentAdapter extends FragmentStateAdapter {
    public ProfileDocFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0)
        {
            return new General_Info();
        }else if (position==1){
            return new Nid_Info();
        }else if (position==2){
            return new SelfieInfo();
        }
        return new General_Info();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}