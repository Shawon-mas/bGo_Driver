package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.vehicle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.SettingVehicleFragmentAdapter;
import com.app.bgodriver.databinding.FragmentVehicleBinding;
import com.app.bgodriver.view.homeFragmentsUi.Setting;
import com.google.android.material.tabs.TabLayout;


public class Vehicle extends Fragment {
   private FragmentVehicleBinding binding;
   private SettingVehicleFragmentAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentVehicleBinding.inflate(inflater, container, false);
        binding.backVehicle.setOnClickListener(v -> {
            Fragment fragment=new Setting();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            transaction.replace(R.id.home_container, fragment);
            transaction.commit();
        });
        implementTabLayout();
        return binding.getRoot();
    }

    private void implementTabLayout() {
        binding.vehicleTabLayout.addTab(binding.vehicleTabLayout.newTab().setText("Vehicle list"));
        binding.vehicleTabLayout.addTab(binding.vehicleTabLayout.newTab().setText("Add Vehicle"));
        adapter=new SettingVehicleFragmentAdapter(getActivity().getSupportFragmentManager(),getActivity().getLifecycle());
        binding.vehicleViewPager2.setAdapter(adapter);
        binding.vehicleTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.vehicleViewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.vehicleViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.vehicleTabLayout.selectTab(binding.vehicleTabLayout.getTabAt(position));

            }
        });

    }
}