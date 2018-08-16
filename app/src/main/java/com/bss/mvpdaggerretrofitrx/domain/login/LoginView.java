package com.bss.mvpdaggerretrofitrx.domain.login;

import com.bss.mvpdaggerretrofitrx.service.model.LoginResponse;
import com.hannesdorfmann.mosby.mvp.MvpView;

public interface LoginView extends MvpView {                                       //1  chứa những cái cần hiển thị khi ng dùng tương tác

    void showLoading();

    void hideLoading();

    void loginSuccessful(LoginResponse loginResponse);

    void loginFailed(Throwable throwable);
}
