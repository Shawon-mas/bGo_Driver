package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.DriverAdapter;
import com.app.bgodriver.databinding.FragmentDriverListBinding;
import com.app.bgodriver.model.DriverModel;

import java.util.ArrayList;


public class DriverList extends Fragment {
    private FragmentDriverListBinding binding;
    private ArrayList<DriverModel> driverModelArrayList;
    private DriverAdapter adapter;
    int[] images = {R.drawable.my,
            R.drawable.my,
            R.drawable.my
           };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentDriverListBinding.inflate(inflater, container, false);
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
        adapter=new DriverAdapter(getContext(),driverModelArrayList);
        binding.driverListRecycler.setAdapter(adapter);


    }
}