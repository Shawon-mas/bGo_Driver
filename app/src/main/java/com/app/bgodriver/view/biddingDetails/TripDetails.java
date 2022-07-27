package com.app.bgodriver.view.biddingDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityTripDetailsBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class TripDetails extends AppCompatActivity {
    private ActivityTripDetailsBinding binding;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTripDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        implementBottomSheet();
        initViews();
    }

    private void initViews() {
        binding.startPointValue.setText(getIntent().getStringExtra("vOne"));
        binding.endPointValue.setText(getIntent().getStringExtra("vTwo"));
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
}