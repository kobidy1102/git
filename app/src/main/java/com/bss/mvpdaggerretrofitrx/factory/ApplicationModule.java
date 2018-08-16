package com.bss.mvpdaggerretrofitrx.factory;

import android.content.pm.ApplicationInfo;

import com.bss.mvpdaggerretrofitrx.service.authentication.RestAuthenticationService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {                //1   dùng để khởi tạo 1 đối tượng khi nào cần thì lấy ra xài thôi chứ ko tạo ra nhiều, giống static

    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://kiddi.api.web.beesightsoft.com/api/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public RestAuthenticationService provideAuthenticationService(Retrofit retrofit) {       //chạy zô đây rồi đây cần 1 thằng retrofit nên sẽ chạy lên hàm trên để new ra retrofit
        return retrofit.create(RestAuthenticationService.class);
    }


}
