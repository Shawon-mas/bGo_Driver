package com.app.bgodriver.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.profile.DocumentFragment;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.profile.PersonalFragment;

public class ProfileFragmentAdapter extends FragmentStateAdapter {
    public ProfileFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0)
        {
            return new PersonalFragment();
        }else if (position==1){
            return new DocumentFragment();
        }
        return new PersonalFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}