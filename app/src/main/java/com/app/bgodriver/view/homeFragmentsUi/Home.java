package com.app.bgodriver.view.homeFragmentsUi;

import static com.app.bgodriver.model.a.isVisible;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.bgodriver.adapter.TripsFragmentAdapter;
import com.app.bgodriver.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;


public class Home extends Fragment {
  private FragmentHomeBinding binding;
  private TripsFragmentAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater, container, false);
        implementTabLayout();
        return binding.getRoot();
    }

    private void implementTabLayout() {
        binding.homeTabLayout.addTab(binding.homeTabLayout.newTab().setText("Available trips"));
        binding.homeTabLayout.addTab(binding.homeTabLayout.newTab().setText("Bids ongoing"));
        adapter=new TripsFragmentAdapter(getActivity().getSupportFragmentManager(),getActivity().getLifecycle());
        binding.homeViewPager2.setAdapter(adapter);
        binding.homeTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.homeViewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.homeViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.homeTabLayout.selectTab(binding.homeTabLayout.getTabAt(position));

            }
        });


    }
}