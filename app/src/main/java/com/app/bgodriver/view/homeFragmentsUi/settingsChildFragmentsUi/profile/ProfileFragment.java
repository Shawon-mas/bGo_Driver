package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.ProfileFragmentAdapter;

import com.app.bgodriver.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabLayout;


public class ProfileFragment extends Fragment {
  private FragmentProfileBinding binding;
  private ProfileFragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentProfileBinding.inflate(inflater,container,false);
        implementTabLayout();
        return binding.getRoot();
    }

    private void implementTabLayout() {
        binding.profileTabLayout.addTab(binding.profileTabLayout.newTab().setText("Personal"));
        binding.profileTabLayout.addTab(binding.profileTabLayout.newTab().setText("Document"));
        adapter=new ProfileFragmentAdapter(getActivity().getSupportFragmentManager(),getActivity().getLifecycle());
        binding.profileViewPager2.setAdapter(adapter);
        binding.profileTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.profileViewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.profileViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.profileTabLayout.selectTab(binding.profileTabLayout.getTabAt(position));

            }
        });
    }
}