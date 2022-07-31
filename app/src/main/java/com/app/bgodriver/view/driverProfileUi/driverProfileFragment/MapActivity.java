package com.app.bgodriver.view.driverProfileUi.driverProfileFragment;

import static com.app.bgodriver.utilites.Constants.KEY_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityMapBinding;
import com.app.bgodriver.utilites.PreferenceManager;


public class MapActivity extends AppCompatActivity {
    private ActivityMapBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager=new PreferenceManager(getApplicationContext());
        binding=ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.general_container,new MapFragment());
        ft.commit();


        /*String name="mas";
        binding.mapButton.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),PersonalInfoActivity.class);
            intent.putExtra(KEY_LOCATION,name);
            startActivity(intent);
            finish();
        });*/
    }
}