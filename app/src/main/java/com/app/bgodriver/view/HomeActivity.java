package com.app.bgodriver.view;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityHomeBinding;
import com.app.bgodriver.model.DriverModel;
import com.app.bgodriver.view.homeFragmentsUi.History;
import com.app.bgodriver.view.homeFragmentsUi.Home;
import com.app.bgodriver.view.homeFragmentsUi.Offer;
import com.app.bgodriver.view.homeFragmentsUi.Setting;
import com.app.bgodriver.view.theme.GetTheme;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ActivityHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bottomNavImplement();


    }

    private void bottomNavImplement() {

        binding.bottomNavigation.setOnNavigationItemSelectedListener(this);
        binding.bottomNavigation.setSelectedItemId(R.id.navigation_home);


    }

    Home homeFragment=new Home();
    Offer offerFragment=new Offer();
    History historyFragment=new History();
    Setting settingFragment=new Setting();

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,homeFragment).commit();
                return true;
            case R.id.navigation_offer:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,offerFragment).commit();
                return true;
            case R.id.navigation_history:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,historyFragment).commit();
                return true;
            case R.id.navigation_setting:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,settingFragment).commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {

        AlertDialog alertDialog = new AlertDialog.Builder(HomeActivity.this).create();
        alertDialog.setTitle("Wait !");
        alertDialog.setMessage("Do you want to close the application?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                (dialog, which) -> {
                    dialog.dismiss();
                    finishAndRemoveTask();
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();


    }
}