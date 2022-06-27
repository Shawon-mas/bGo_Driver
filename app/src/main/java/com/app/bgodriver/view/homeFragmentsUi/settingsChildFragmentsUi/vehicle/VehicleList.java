package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.vehicle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.adapter.VehicleListAdapter;
import com.app.bgodriver.databinding.FragmentVehicleListBinding;
import com.app.bgodriver.model.VehicleListModel;

import java.util.ArrayList;


public class VehicleList extends Fragment {
      private FragmentVehicleListBinding binding;
      private VehicleListAdapter adapter;
    private ArrayList<VehicleListModel> vehicleListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentVehicleListBinding.inflate(inflater, container, false);
        implementRecyclerview();
        return binding.getRoot();
    }

    private void implementRecyclerview() {
        binding.vehicleListRecycler.setHasFixedSize(true);
        binding.vehicleListRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        vehicleListModelArrayList=new ArrayList<>();
        vehicleListModelArrayList.add(new VehicleListModel(
           "Toyota Sedan Car","true","Dhaka Metro HA-258795",
                "Zed Black","Allion 2010","6 person","Yes"
        ));
        vehicleListModelArrayList.add(new VehicleListModel(
                "Tata Sedan Car","false","Dhaka Metro HA-200795",
                "Zed Black","Allion 2010","6 person","No"
        ));
        adapter=new VehicleListAdapter(getContext(),vehicleListModelArrayList);
        binding.vehicleListRecycler.setAdapter(adapter);

    }
}