package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.bGoHelp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.HelpAdapter;
import com.app.bgodriver.databinding.FragmentBgoHelpBinding;
import com.app.bgodriver.model.ItemClick;
import com.app.bgodriver.view.homeFragmentsUi.homeChildFragmentUi.AvailableTrips;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver.DriverList;
import com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.profile.ProfileFragment;

import java.util.ArrayList;
import java.util.List;


public class bgoHelp extends Fragment implements ItemClick {
    private FragmentBgoHelpBinding binding;
    List<String> titles;
    private HelpAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
                binding=FragmentBgoHelpBinding.inflate(inflater,container,false);
                implementRecycler();
                return binding.getRoot();
    }

    private void implementRecycler() {
        titles = new ArrayList<>();
         titles.add("All");
         titles.add("Credit");
         titles.add("Trip");
         titles.add("Rules");
        binding.bGoHelpRecycler.setHasFixedSize(true);
        binding.bGoHelpRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter=new HelpAdapter(titles,getContext(), this);
        binding.bGoHelpRecycler.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {
        switch (position)
        {
            case 0:

                Fragment fragment=new AvailableTrips();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                transaction.replace(R.id.help_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 1:
                Fragment fragment1=new DriverList();
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                transaction1.replace(R.id.help_container, fragment1);
                transaction1.addToBackStack(null);
                transaction1.commit();
                break;
        }

    }
}