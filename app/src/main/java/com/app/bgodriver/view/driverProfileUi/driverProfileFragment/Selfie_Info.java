package com.app.bgodriver.view.driverProfileUi.driverProfileFragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.app.bgodriver.databinding.FragmentSelfieInfoBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class Selfie_Info extends Fragment {
    private FragmentSelfieInfoBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentSelfieInfoBinding.inflate(inflater, container, false);
        //  sendDta(binding.t1.getText().toString());
        pickImage();

        return binding.getRoot();
    }

    private void pickImage()
    {
        binding.imageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(getActivity())
                        .crop()
                        .cropSquare()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .createIntent(intent -> {
                            startForMediaPickerResult.launch(intent);
                            return null;
                        });
            }
        });
    }
    private final ActivityResultLauncher<Intent> startForMediaPickerResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent data = result.getData();
                if (data != null && result.getResultCode() == Activity.RESULT_OK)
                {
                    Uri uri = data.getData();


                    binding.profileImage.setImageURI(uri);
                    binding.profileImage.invalidate();

                }
                else{
                    Toast.makeText(requireActivity(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
                }

            });

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

}