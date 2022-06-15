package com.app.bgodriver.view.driverProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.app.bgodriver.R;
import com.app.bgodriver.adapter.VehicleFragmentAdapter;

import com.app.bgodriver.databinding.ActivityVehicleInfoBinding;
import com.app.bgodriver.view.HomeActivity;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class VehicleInfoActivity extends AppCompatActivity {
    private ActivityVehicleInfoBinding binding;
    private VehicleFragmentAdapter adapter;
    Dialog dialog;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVehicleInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        clickListener();
        stepViewImplement();
    }

    private void stepViewImplement() {
        binding.stepViewVehicle.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.bGo_textColorPrimary))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.bGo_mainColor))
                .selectedCircleRadius(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._14sdp))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.white))
                .steps(new ArrayList<String>() {{
                    add("General Info");
                    add("Car Image");
                    add("Registration");
                }})
                .stepsNumber(3)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._1sdp))
                .textSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .stepNumberTextSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .typeface(ResourcesCompat.getFont(getApplicationContext(), R.font.sf_ui_display))
                .commit();

    }

    private void clickListener()
    {
          binding.nextV.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v)
              {
                  if (binding.viewPagerVehicle.getCurrentItem() < 1)
                  {
                      binding.viewPagerVehicle.setCurrentItem(binding.viewPagerVehicle.getCurrentItem() + 1);
                      binding.stepViewVehicle.go(1,true);
                  }else if (binding.viewPagerVehicle.getCurrentItem() < 2){
                      binding.viewPagerVehicle.setCurrentItem(binding.viewPagerVehicle.getCurrentItem() + 1);
                      binding.stepViewVehicle.go(2,true);
                      binding.doneV.setVisibility(View.VISIBLE);
                      binding.nextV.setVisibility(View.GONE);
                  }
              }
          });
          
          binding.vBackButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (binding.viewPagerVehicle.getCurrentItem() == 0)
                  {
                      startActivity(new Intent(getApplicationContext(),InitProfileActivity.class));

                  }else if (binding.viewPagerVehicle.getCurrentItem() == 1){
                      binding.viewPagerVehicle.setCurrentItem(binding.viewPagerVehicle.getCurrentItem() - 1);
                      binding.stepViewVehicle.go(0,true);
                      binding.doneV.setVisibility(View.GONE);
                      binding.nextV.setVisibility(View.VISIBLE);
                  }else if (binding.viewPagerVehicle.getCurrentItem() == 2){
                      binding.viewPagerVehicle.setCurrentItem(binding.viewPagerVehicle.getCurrentItem() - 1);
                      binding.stepViewVehicle.go(1,true);
                      binding.doneV.setVisibility(View.GONE);
                      binding.nextV.setVisibility(View.VISIBLE);
                  }
              }
              
          });
          binding.doneV.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) 
              {
                  dialog = new Dialog(VehicleInfoActivity.this);
                  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                  dialog.setContentView(R.layout.loading);
                  dialog.getWindow().setLayout(500, 500);
                  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                  dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                  dialog.getWindow().setGravity(Gravity.CENTER);

                  // dialog1.getWindow().setWindowAnimations(R.style.AnimationForDialog);
                  lottieAnimationView=dialog.findViewById(R.id.animationView);
                  dialog.show();
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                         dialog.cancel();
                          Toast.makeText(VehicleInfoActivity.this, "Success", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                          finish();
                      }
                  },3000);
              }
          });
    }



    private void initView() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        adapter=new VehicleFragmentAdapter(fragmentManager,getLifecycle());
        binding.viewPagerVehicle.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),InitProfileActivity.class));
    }
}