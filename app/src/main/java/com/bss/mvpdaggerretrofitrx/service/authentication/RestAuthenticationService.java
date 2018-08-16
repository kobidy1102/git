package com.bss.mvpdaggerretrofitrx.service.authentication;

import com.bss.mvpdaggerretrofitrx.service.model.LoginRequest;
import com.bss.mvpdaggerretrofitrx.service.model.LoginResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface RestAuthenticationService {

    @POST("auth/signIn")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);
}
