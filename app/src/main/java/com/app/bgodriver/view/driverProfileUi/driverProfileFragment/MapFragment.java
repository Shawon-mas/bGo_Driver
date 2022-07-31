package com.app.bgodriver.view.driverProfileUi.driverProfileFragment;

import static com.app.bgodriver.utilites.Constants.KEY_LOCATION;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.FragmentMapBinding;
import com.app.bgodriver.view.driverProfileUi.PersonalInfoActivity;


public class MapFragment extends Fragment {
      private FragmentMapBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentMapBinding.inflate(inflater, container, false);
       initViews();
        return binding.getRoot();
    }

    private void initViews() {
        String name="mas";
        binding.mapButton.setOnClickListener(v -> {
            Intent intent=new Intent(getActivity(), PersonalInfoActivity.class);
            intent.putExtra(KEY_LOCATION,name);
            startActivity(intent);
        });
    }
}