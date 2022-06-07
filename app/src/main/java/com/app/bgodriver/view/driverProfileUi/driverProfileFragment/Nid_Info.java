package com.app.bgodriver.view.driverProfileUi.driverProfileFragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.bgodriver.databinding.FragmentNidInfoBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class Nid_Info extends Fragment {
    private FragmentNidInfoBinding binding;
    Fragment fragment = this;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentNidInfoBinding.inflate(inflater, container, false);


        //  sendDta(binding.t1.getText().toString());
        pickImage();

        return binding.getRoot();
    }

    private void pickImage() {
        binding.nidFrontImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(getActivity())
                        .crop(16f, 9f)
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .createIntent(intent -> {
                            startForMediaPickerResult.launch(intent);
                            return null;
                        });


            }
        });
        binding.nidBackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(getActivity())
                        .crop(16f, 9f)

                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .createIntent(intent -> {
                            startForMediaPickerResult2.launch(intent);
                            return null;
                        });
            }
        });
        binding.drivingLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(getActivity())
                        .crop(16f, 9f)
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .createIntent(intent -> {
                            startForMediaPickerResult3.launch(intent);
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
                    binding.fontNidImage.setVisibility(View.VISIBLE);

                    binding.nidFrontImage.setVisibility(View.GONE);
                    binding.textFornt.setVisibility(View.GONE);

                    binding.fontNidImage.setImageURI(uri);
                    binding.fontNidImage.invalidate();

                }
                else{
                        Toast.makeText(requireActivity(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
                    }

                });
    private final ActivityResultLauncher<Intent> startForMediaPickerResult2 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent data = result.getData();
                if (data != null && result.getResultCode() == Activity.RESULT_OK)
                {
                    Uri uri = data.getData();


                    binding.nidBackImage.setVisibility(View.GONE);
                    binding.textFornt2.setVisibility(View.GONE);

                    binding.backNidImage.setVisibility(View.VISIBLE);
                    binding.backNidImage.setImageURI(uri);
                    binding.backNidImage.invalidate();

                }
                else{
                    Toast.makeText(requireActivity(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
                }

            });
    private final ActivityResultLauncher<Intent> startForMediaPickerResult3 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent data = result.getData();
                if (data != null && result.getResultCode() == Activity.RESULT_OK)
                {
                    Uri uri = data.getData();


                    binding.drivingLicense.setVisibility(View.GONE);
                    binding.textFornt3.setVisibility(View.GONE);

                    binding.diImage.setVisibility(View.VISIBLE);
                    binding.diImage.setImageURI(uri);
                    binding.diImage.invalidate();

                }
                else{
                    Toast.makeText(requireActivity(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
                }

            });

}
/*

 */