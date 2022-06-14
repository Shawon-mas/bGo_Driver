package com.app.bgodriver.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.bgodriver.view.homeFragmentsUi.homeChildFragmentUi.AvailableTrips;
import com.app.bgodriver.view.homeFragmentsUi.homeChildFragmentUi.BidsOngoing;

public class TripsFragmentAdapter extends FragmentStateAdapter {
    public TripsFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new AvailableTrips();
        }else if (position==1){
            return new BidsOngoing();
        }
        return new AvailableTrips();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
