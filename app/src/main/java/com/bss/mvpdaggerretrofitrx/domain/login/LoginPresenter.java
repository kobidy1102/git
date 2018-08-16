package com.bss.mvpdaggerretrofitrx.domain.login;

import com.bss.mvpdaggerretrofitrx.service.authentication.RestAuthenticationService;
import com.bss.mvpdaggerretrofitrx.service.model.LoginRequest;
import com.bss.mvpdaggerretrofitrx.service.model.LoginResponse;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginPresenter extends MvpBasePresenter<LoginView> {

    private RestAuthenticationService restAuthenticationService;

    public LoginPresenter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://kiddi.api.web.beesightsoft.com/api/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restAuthenticationService = retrofit.create(RestAuthenticationService.class);
    }

    public void login(String email, String password) {
        getView().showLoading();
        restAuthenticationService.login(new LoginRequest(email, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        getView().hideLoading();
                    }
                })
                .subscribe(new Action1<LoginResponse>() {
                    @Override
                    public void call(LoginResponse loginResponse) {
                        getView().loginSuccessful(loginResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().loginFailed(throwable);
                    }
                });

    }
}
