package com.app.bgodriver.api.loginWithPhoneAPi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("auth/login-with-phone")
    Call<DataResponse> userOtp(@Body DataRequest dataRequest);
}
