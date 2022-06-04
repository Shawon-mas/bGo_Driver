package com.app.bgodriver.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
              //  binding.loginIndicator.setVisibility(View.VISIBLE);
                validation();

                sendOtp();
            }
        });
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
                  //  binding.loginIndicator.setVisibility(View.INVISIBLE);
                    DataResponse dataResponse=response.body();
                    String message=dataResponse.getMessage();
                    Intent intent=new Intent(getApplicationContext(),OtpActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(),message ,Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t)
            {
                Log.d("Message:",t.getMessage());
            }
        });

    }
}