package com.bss.mvpdaggerretrofitrx.service.model;

import com.google.gson.annotations.SerializedName;

public class User {                                                           //6 Json repone cần 1 cái Json Object nên tạo cái này.

    @SerializedName("access_token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
