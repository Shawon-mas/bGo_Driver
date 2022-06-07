package com.app.bgodriver.view.driverProfileUi.driverProfileFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.app.bgodriver.databinding.FragmentGeneralInfoBinding;
import com.app.bgodriver.model.FragmentToActivity;


public class General_Info extends Fragment {

   private FragmentGeneralInfoBinding binding;
    private FragmentToActivity mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentGeneralInfoBinding.inflate(inflater, container, false);
        //  sendDta(binding.t1.getText().toString());
        return binding.getRoot();
    }
    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

    public void onRefresh() {
        Toast.makeText(getActivity(), "Fragment : Refresh called.",
                Toast.LENGTH_SHORT).show();
    }
    private void sendDta(String text) {
        mCallback.communicate(text,null);

    }
}