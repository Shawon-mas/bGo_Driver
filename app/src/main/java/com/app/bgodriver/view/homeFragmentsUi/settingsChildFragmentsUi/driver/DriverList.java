package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.DriverAdapter;

import com.app.bgodriver.databinding.FragmentDriverListBinding;
import com.app.bgodriver.model.DriverModel;
import com.app.bgodriver.view.homeFragmentsUi.Setting;

import java.util.ArrayList;


public class DriverList extends Fragment {
    private FragmentDriverListBinding binding;
    private ArrayList<DriverModel> driverModelArrayList;
    private DriverAdapter adapter;
    int[] images = {R.drawable.my,
            R.drawable.my,
            R.drawable.my,
            R.drawable.sobuj
           };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentDriverListBinding.inflate(inflater, container, false);
        binding.backDriver.setOnClickListener(v -> {
            Fragment fragment=new Setting();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            transaction.replace(R.id.home_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
        implementRecyclerview();
        return binding.getRoot();    }

    private void implementRecyclerview() {
        binding.driverListRecycler.setHasFixedSize(true);
        binding.driverListRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        driverModelArrayList=new ArrayList<>();
        driverModelArrayList.add(new DriverModel(
                "Mahabub Alam Shawon","45TSFGFSG","20/11/2025","01776646603",
                "150/A Mirpur DOHS Dhaka 1212","false",images[0]
        ));
        driverModelArrayList.add(new DriverModel(
                "Jia-Ul-Haque","45TSFGFSG","20/11/2025","01776646603",
                "North Dhanmondi, Dhaka-1205","true",images[1]
        ));
        driverModelArrayList.add(new DriverModel(
                "Sobuj Islam","45TSFGFSG","20/11/2025","01776646603",
                "North Dhanmondi, Dhaka-1205","true",images[3]
        ));
        adapter=new DriverAdapter(getContext(),driverModelArrayList);
        binding.driverListRecycler.setAdapter(adapter);


    }
}