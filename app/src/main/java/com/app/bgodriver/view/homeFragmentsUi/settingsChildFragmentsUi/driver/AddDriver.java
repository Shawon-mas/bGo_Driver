package com.app.bgodriver.view.homeFragmentsUi.settingsChildFragmentsUi.driver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.AddDriverFragmentAdapter;
import com.app.bgodriver.databinding.ActivityAddDriverBinding;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class AddDriver extends AppCompatActivity {
    private ActivityAddDriverBinding binding;
    private AddDriverFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddDriverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListener();
        stepViewImplement();
    }

    private void stepViewImplement() {
        binding.stepAddDriver.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.bGo_textColorPrimary))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.bGo_mainColor))
                .selectedCircleRadius(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._14sdp))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.white))
                .steps(new ArrayList<String>() {{
                    add("General Info");
                    add("License");
                    add("Document");
                }})
                .stepsNumber(3)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._1sdp))
                .textSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .stepNumberTextSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .typeface(ResourcesCompat.getFont(getApplicationContext(), R.font.sf_ui_display))
                .commit();

        FragmentManager fragmentManager=getSupportFragmentManager();
        adapter=new AddDriverFragmentAdapter(fragmentManager,getLifecycle());
        binding.addDriverViewPager.setAdapter(adapter);
        binding.addDriverViewPager.setUserInputEnabled(false);


    }

    private void clickListener() {
        binding.addDriverNexStepButton.setOnClickListener(v -> {
            if (binding.addDriverViewPager.getCurrentItem() < 1)
            {
                binding.addDriverViewPager.setCurrentItem(binding.addDriverViewPager.getCurrentItem() + 1);
                binding.stepAddDriver.go(1,true);
            }else if (binding.addDriverViewPager.getCurrentItem() < 2)
            {
                binding.addDriverViewPager.setCurrentItem(binding.addDriverViewPager.getCurrentItem() + 1);
                binding.stepAddDriver.go(2,true);
                binding.addDriverDoneButton.setVisibility(View.VISIBLE);
                binding.addDriverNexStepButton.setVisibility(View.GONE);
            }
        });

    }
}