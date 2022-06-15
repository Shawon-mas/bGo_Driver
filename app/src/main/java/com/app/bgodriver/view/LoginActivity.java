package com.app.bgodriver.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.app.bgodriver.R;
import com.app.bgodriver.api.loginWithPhoneAPi.ApiInstance;
import com.app.bgodriver.api.loginWithPhoneAPi.ApiInterface;
import com.app.bgodriver.api.loginWithPhoneAPi.DataRequest;
import com.app.bgodriver.api.loginWithPhoneAPi.DataResponse;
import com.app.bgodriver.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    Dialog dialog;
    LottieAnimationView lottieAnimationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListener();

    }

    private void clickListener() {
        binding.loginLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),OtpActivity.class));
                finish();
             //   dialogBox();

              //  binding.loginIndicator.setVisibility(View.VISIBLE);
              //  validation();
              //  sendOtp();
            }
        });
    }

    private void dialogBox() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading);
        dialog.getWindow().setLayout(500, 500);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // dialog1.getWindow().setWindowAnimations(R.style.AnimationForDialog);
        lottieAnimationView=dialog.findViewById(R.id.animationView);
        dialog.show();
    }

    private void validation() {
        if(binding.loginPhoneEditText.getText().toString().isEmpty())
        {
            binding.loginPhoneEditText.setError("Enter Your Phone Number");
            binding.loginPhoneEditText.requestFocus();
        }
        if(binding.loginPhoneEditText.getText().toString().length()<11){
            binding.loginPhoneEditText.setError("Number should be 11 digit");
            binding.loginPhoneEditText.requestFocus();
        }
    }

    private void sendOtp()
    {
        DataRequest dataRequest=new DataRequest();
        dataRequest.setPhone(binding.loginPhoneEditText.getText().toString());
        Call<DataResponse> dataResponseCall= ApiInstance.getApiInterface().userOtp(dataRequest);
        dataResponseCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful())
                {
                    dialog.cancel();
                    binding.loginIndicator.setVisibility(View.INVISIBLE);
                    DataResponse dataResponse=response.body();
                    String message=dataResponse.getMessage();
                    Intent intent=new Intent(getApplicationContext(),OtpActivity.class);
                    intent.putExtra("userOtp",dataResponse.getOtp());
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),message ,Toast.LENGTH_LONG).show();
                    Log.d("Otp:",dataResponse.getOtp());

                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t)
            {
                dialog.cancel();
                binding.loginIndicator.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"Something Went Wrong" ,Toast.LENGTH_LONG).show();
                Log.d("Message:",t.getMessage());
            }
        });

    }
}