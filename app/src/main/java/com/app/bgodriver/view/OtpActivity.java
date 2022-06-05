package com.app.bgodriver.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityLoginBinding;
import com.app.bgodriver.databinding.ActivityOtpBinding;
import com.app.bgodriver.view.driverProfileUi.InitProfileActivity;

import in.aabhasjindal.otptextview.OTPListener;

public class OtpActivity extends AppCompatActivity {
    private ActivityOtpBinding binding;
    private String getOtp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        otpVerify();
    }

    private void otpVerify() {
        binding.otpPin.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(String otp) {
                     getOtp=otp;
            }
        });
        binding.otpVerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (binding.otpPin.getOTP().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Otp",  Toast.LENGTH_SHORT).show();
                }else {
                    String userOtp=getIntent().getStringExtra("userOtp");
                    if (getOtp.equals(userOtp))
                    {
                        Toast.makeText(getApplicationContext(), "User verified",  Toast.LENGTH_SHORT).show();
                        goToNext();

                    }else {
                        Toast.makeText(getApplicationContext(), "User not verify",  Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void goToNext()
    {
            startActivity(new Intent(getApplicationContext(), InitProfileActivity.class));
    }
}
/*

 */