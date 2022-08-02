package com.app.bgodriver.view.biddingDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityTripDetailsBinding;
import com.app.bgodriver.mapdirectionhelpers.FetchURL;
import com.app.bgodriver.mapdirectionhelpers.TaskLoadedCallback;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class TripDetails extends AppCompatActivity implements OnMapReadyCallback, TaskLoadedCallback {
    private ActivityTripDetailsBinding binding;
    private BottomSheetBehavior bottomSheetBehavior;
    private GoogleMap mMap;
    private MarkerOptions place1, place2;
    private Polyline currentPolyline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTripDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        implementBottomSheet();
        initViews();
    }

    private void initViews() {

       // new FetchURL(TripDetails.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        binding.startPointValue.setText(getIntent().getStringExtra("vOne"));
        binding.endPointValue.setText(getIntent().getStringExtra("vTwo"));

        place1 = new MarkerOptions().position(new LatLng(27.658143, 85.3199503)).title("Location 1");
        place2 = new MarkerOptions().position(new LatLng(27.667491, 85.3208583)).title("Location 2");

        String url=getUrl(place1.getPosition(), place2.getPosition(), "driving");
        new FetchURL(TripDetails.this).execute(url,"driving");

    }

    private void implementBottomSheet()
    {
          bottomSheetBehavior=BottomSheetBehavior.from(binding.bottomSheet);
          bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
              @Override
              public void onStateChanged(@NonNull View bottomSheet, int newState) {
                  switch (newState)
                  {
                      case BottomSheetBehavior.STATE_COLLAPSED:
                          binding.tripDragIcon.setVisibility(View.VISIBLE);
                          break;
                      case BottomSheetBehavior.STATE_DRAGGING:
                          break;
                      case BottomSheetBehavior.STATE_EXPANDED:
                          binding.tripDragIcon.setVisibility(View.GONE);
                          break;
                      case BottomSheetBehavior.STATE_HIDDEN:

                          break;
                      case BottomSheetBehavior.STATE_SETTLING:
                          binding.tripDragIcon.setVisibility(View.VISIBLE);
                          break;
                  }
              }

              @Override
              public void onSlide(@NonNull View bottomSheet, float slideOffset) {

              }
          });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        Log.d("mylog", "Added Markers");
        mMap.addMarker(place1);
        mMap.addMarker(place2);

    }
    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_map_api);
        return url;
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
    }
}