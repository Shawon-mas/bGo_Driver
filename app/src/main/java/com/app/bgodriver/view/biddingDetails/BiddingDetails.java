package com.app.bgodriver.view.biddingDetails;

import static com.app.bgodriver.global.Constant.AIRCONDITION_KEY;
import static com.app.bgodriver.global.Constant.CURRENTLOCATION_KEY;
import static com.app.bgodriver.global.Constant.DESTINATIONLOCATION_KEY;
import static com.app.bgodriver.global.Constant.ROUNDTRIP_KEY;
import static com.app.bgodriver.global.Constant.TRIPPASSENGER_KEY;
import static com.app.bgodriver.global.Constant.TRIPTIME_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.app.bgodriver.databinding.ActivityBiddingDetailsBinding;


public class BiddingDetails extends AppCompatActivity {
    private ActivityBiddingDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBiddingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setBiddingData();
    }

    private void setBiddingData() {

        String destinationLocation= getIntent().getStringExtra(DESTINATIONLOCATION_KEY);
        String currentLocation= getIntent().getStringExtra(CURRENTLOCATION_KEY);
        String tripTime= getIntent().getStringExtra(TRIPTIME_KEY);
        String roundTrip= getIntent().getStringExtra(ROUNDTRIP_KEY);
        String passenger= getIntent().getStringExtra(TRIPPASSENGER_KEY);
        String airCondition= getIntent().getStringExtra(AIRCONDITION_KEY);
        int image=getIntent().getIntExtra("image",0);

        binding.biddingDetailsDestination.setText(destinationLocation);
        binding.biddingDetailsCurrentLocation.setText(currentLocation);
        binding.biddingDetailsDate.setText(tripTime);
        binding.biddingDetailsRound.setText(roundTrip);
        binding.biddingDetailsPassenger.setText(passenger);
        binding.biddingDetailsAcType.setText(airCondition);
        binding.biddingDetailsImage.setImageResource(image);



    }
}