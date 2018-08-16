package com.bss.mvpdaggerretrofitrx.service.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {                          //5 nhận được, theo cấu trúc  Json (phần respone)

    @SerializedName("data")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
