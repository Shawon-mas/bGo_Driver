package com.app.bgodriver.view.driverProfileUi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.app.bgodriver.databinding.FragmentStep2Binding;
import com.app.bgodriver.model.FragmentToActivity;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

public class Step2 extends Fragment implements Step {
    private FragmentStep2Binding binding;
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
        binding=FragmentStep2Binding.inflate(inflater, container, false);
        sendDta(binding.t2.getText().toString());
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

    private void sendDta(String toString) {
        mCallback.communicate(toString,null);
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}