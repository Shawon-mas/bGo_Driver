package com.app.bgodriver.view.driverProfileUi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.app.bgodriver.R;
import com.app.bgodriver.databinding.FragmentStep1Binding;
import com.app.bgodriver.model.FragmentToActivity;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;


public class Step1 extends Fragment implements Step {
    private FragmentStep1Binding binding;
    private FragmentToActivity mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentToActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentToActivity");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentStep1Binding.inflate(inflater, container, false);
      //  sendDta(binding.t1.getText().toString());
        clickListener();
        return binding.getRoot();
    }

    private void clickListener() {
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

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
        Toast.makeText(getContext(),"step 1",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}