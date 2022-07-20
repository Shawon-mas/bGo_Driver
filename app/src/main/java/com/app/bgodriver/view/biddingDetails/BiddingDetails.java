package com.app.bgodriver.view.biddingDetails;

import static com.app.bgodriver.global.Constant.AIRCONDITION_KEY;
import static com.app.bgodriver.global.Constant.CURRENTLOCATION_KEY;
import static com.app.bgodriver.global.Constant.DESTINATIONLOCATION_KEY;
import static com.app.bgodriver.global.Constant.ROUNDTRIP_KEY;
import static com.app.bgodriver.global.Constant.TRIPPASSENGER_KEY;
import static com.app.bgodriver.global.Constant.TRIPTIME_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.MyVehicleAdapter;
import com.app.bgodriver.databinding.ActivityBiddingDetailsBinding;
import com.app.bgodriver.model.BidingItemClick;
import com.app.bgodriver.model.MyVehicleModel;
import com.app.bgodriver.model.TripModel;

import java.util.ArrayList;


public class BiddingDetails extends AppCompatActivity implements BidingItemClick {
    private ArrayList<TripModel> tripModelArrayList;
    private ActivityBiddingDetailsBinding binding;
    private ArrayList<MyVehicleModel> myVehicleModelArrayList;
    private MyVehicleAdapter adapter;
    int[] images = {R.drawable.black_car,
            R.drawable.blue_car,
            R.drawable.car_image
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBiddingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListeners();
        addDriver();
        implementRecycler();
        setBiddingData();
    }

    private void clickListeners() {
        binding.biddingBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    private void addDriver() {
        String[] driver=new String[] {"Sobuj Islam","Md Khaled"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(
                this,
                R.layout.drorp_down_item,
                driver
        );
        binding.filledExposed.setAdapter(arrayAdapter);
        binding.filledExposed.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(),binding.filledExposed.getText().toString(),Toast.LENGTH_SHORT).show();
        });
    }

    private void implementRecycler() {
        binding.myVehicleRecycler.setHasFixedSize(true);
        myVehicleModelArrayList= new ArrayList<>();
        myVehicleModelArrayList.add(new MyVehicleModel(
                images[2],"Toyota Noah 2007","(HA- 587984)"
        ));
        myVehicleModelArrayList.add(new MyVehicleModel(
                images[0],"Toyota Noah 2010","(HA- 167900)"
        ));
        adapter=new MyVehicleAdapter(getApplicationContext(),myVehicleModelArrayList);
        binding.myVehicleRecycler.setAdapter(adapter);

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

    @Override
    public void onBidClick(int position) {

    }
}