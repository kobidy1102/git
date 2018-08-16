package com.bss.mvpdaggerretrofitrx.factory;

import com.bss.mvpdaggerretrofitrx.domain.login.LoginActivity;

import dagger.Component;

@Component(modules = ApplicationModule.class)        //3  dùng để kết nói module và inject ,
public interface ApplicationComponent {
    void inject(LoginActivity loginActivity);       // gán đối tượng zô loginActivity
}
