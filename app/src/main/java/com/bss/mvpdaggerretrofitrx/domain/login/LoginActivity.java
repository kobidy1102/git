package com.bss.mvpdaggerretrofitrx.domain.login;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.bss.mvpdaggerretrofitrx.R;
import com.bss.mvpdaggerretrofitrx.service.model.LoginResponse;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class LoginActivity extends MvpActivity<LoginView, LoginPresenter>
implements LoginView {

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @AfterViews
    protected void initView() {

    }

   @Click(R.id.btn_login)
   protected void clickLogin() {
        presenter.login("phong@gmail.com", "123456");
   }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Show loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "Hide loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessful(LoginResponse loginResponse) {
        Toast.makeText(this, "Login Successful: "
                + loginResponse.getUser().getAccessToken(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(Throwable throwable) {

    }
}
