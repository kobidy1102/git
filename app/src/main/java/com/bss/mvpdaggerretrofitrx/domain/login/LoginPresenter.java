package com.bss.mvpdaggerretrofitrx.domain.login;

import com.bss.mvpdaggerretrofitrx.service.authentication.RestAuthenticationService;
import com.bss.mvpdaggerretrofitrx.service.model.LoginRequest;
import com.bss.mvpdaggerretrofitrx.service.model.LoginResponse;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginPresenter extends MvpBasePresenter<LoginView> {            //2     inJect  2 chỗ để nó nhận được đối tượng mà cái kia nó gán zô ở LoginActivity

    @Inject                                                     //chỗ này cần  đối tượng restauthen.. nên ịnect
    protected RestAuthenticationService restAuthenticationService;

    @Inject
    public LoginPresenter() {             //inject chỗ này luôn để nó nhận dc đối tượng từ loginActivity

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
