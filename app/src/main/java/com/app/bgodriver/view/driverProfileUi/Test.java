package com.app.bgodriver.view.driverProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityInitProfileBinding;
import com.app.bgodriver.databinding.ActivityTestBinding;

public class Test extends AppCompatActivity {
    private ActivityTestBinding binding;
    private MyStepperAdapter myStepperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        impleMent();
    }

    private void initView() {

    }

    private void impleMent() {
         myStepperAdapter=new MyStepperAdapter(getSupportFragmentManager(),getApplicationContext());
         binding.stepperLayout.setAdapter(myStepperAdapter);
      int position=  binding.stepperLayout.getCurrentStepPosition();
        Log.d("pos:",String.valueOf(position));
        binding.nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStepperAdapter.getViewModel(0);
                return;
            }
        });

    }
}