package com.app.bgodriver.view.driverProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.TutorialAdapter;
import com.app.bgodriver.databinding.ActivityInitProfileBinding;
import com.app.bgodriver.databinding.ActivityOtpBinding;
import com.app.bgodriver.model.TutorialModel;

import java.util.ArrayList;

public class InitProfileActivity extends AppCompatActivity {
    private ActivityInitProfileBinding binding;
    private TutorialAdapter adapter;
    private ArrayList<TutorialModel> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInitProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListener();
        implementHowItRecylerView();
    }

    private void clickListener() {
        binding.initProfileProfileDocumentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToProfileActivity();
            }
        });
        binding.initProfileVehicleDocumentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVehicleActivity();
            }
        });
    }

    private void goToVehicleActivity()
    {

    }

    private void goToProfileActivity()
    {

    }

    private void implementHowItRecylerView() {
        binding.howItWorksRecyclerview.setHasFixedSize(true);
        binding.howItWorksRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        modelArrayList=new ArrayList<>();
        modelArrayList.add(new TutorialModel("How to use this app smoothly"));
        modelArrayList.add(new TutorialModel("How to add your document"));
        modelArrayList.add(new TutorialModel("How to start your bidding process"));
        adapter=new TutorialAdapter(getApplicationContext(),modelArrayList);
        binding.howItWorksRecyclerview.setAdapter(adapter);

    }
}