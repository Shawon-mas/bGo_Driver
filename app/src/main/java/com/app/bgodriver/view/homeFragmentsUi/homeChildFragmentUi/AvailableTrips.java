package com.app.bgodriver.view.homeFragmentsUi.homeChildFragmentUi;

import static com.app.bgodriver.global.Constant.AIRCONDITION_KEY;
import static com.app.bgodriver.global.Constant.CURRENTLOCATION_KEY;
import static com.app.bgodriver.global.Constant.DESTINATIONLOCATION_KEY;
import static com.app.bgodriver.global.Constant.ROUNDTRIP_KEY;
import static com.app.bgodriver.global.Constant.TRIPPASSENGER_KEY;
import static com.app.bgodriver.global.Constant.TRIPTIME_KEY;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.bgodriver.R;
import com.app.bgodriver.adapter.TripAdapter;
import com.app.bgodriver.databinding.FragmentAvailableTripsBinding;
import com.app.bgodriver.model.BidingItemClick;
import com.app.bgodriver.model.TripModel;
import com.app.bgodriver.view.biddingDetails.BiddingDetails;

import java.util.ArrayList;


public class AvailableTrips extends Fragment implements BidingItemClick {
private FragmentAvailableTripsBinding binding;
private ArrayList<TripModel> tripModelArrayList;
    int[] images = {R.drawable.black_car,
            R.drawable.blue_car,
            R.drawable.car_image
          };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentAvailableTripsBinding.inflate(inflater,container,false);
        implementRecyclerview();
        return binding.getRoot();
    }

    private void implementRecyclerview() {
        binding.availableTripsRecycler.setHasFixedSize(true);
        binding.availableTripsRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
         tripModelArrayList = new ArrayList<>();
        tripModelArrayList.add(new TripModel(
                images[0],"Mirpur DOHS Road 127 House 32, Dhaka 1207",
                "Mohammadpur bus stand, Dhaka 1200",
                "29 Mar 2022 | 12:00 PM","Yes","6","Yes"
                ));
        tripModelArrayList.add(new TripModel(
                images[1],"Shandhani Unit Rd, Dhaka 1000",
                "Shegunbagicha, Dhaka 1205",
                "12 June 2022 | 12:00 PM","No","4","No"
        ));
        tripModelArrayList.add(new TripModel(
                images[2],"Ramna, Dhaka",
                "Mohammadpur bus stand, Dhaka 1200",
                "29 July 2022 | 12:00 PM","Yes","5","Yes"
        ));
        TripAdapter adapter = new TripAdapter(getContext(), tripModelArrayList, this);
        binding.availableTripsRecycler.setAdapter(adapter);


    }

    @Override
    public void onBidClick(int position) {
        String currentLocation=tripModelArrayList.get(position).getCurrentLocation();
        String destinationLocation=tripModelArrayList.get(position).getDestinationLocation();
        String tripTime=tripModelArrayList.get(position).getTripTime();
        String roundTrip=tripModelArrayList.get(position).getRoundTrip();
        String tripPassenger=tripModelArrayList.get(position).getTripPassenger();
        String airCondition=tripModelArrayList.get(position).getAirCondition();

        Intent intent=new Intent(getActivity(),BiddingDetails.class);
        intent.putExtra(CURRENTLOCATION_KEY,currentLocation);
        intent.putExtra(DESTINATIONLOCATION_KEY,destinationLocation);
        intent.putExtra(TRIPTIME_KEY,tripTime);
        intent.putExtra(ROUNDTRIP_KEY,roundTrip);
        intent.putExtra(TRIPPASSENGER_KEY,tripPassenger);
        intent.putExtra(AIRCONDITION_KEY,airCondition);
        startActivity(intent);

    }
}