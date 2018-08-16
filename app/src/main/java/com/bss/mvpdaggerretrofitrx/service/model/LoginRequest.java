package com.bss.mvpdaggerretrofitrx.service.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("email")
    private String myEmail;

    @SerializedName("password")
    private String password;

    @SerializedName("client_id")
    private String clientId = "1";

    @SerializedName("client_secret")
    private String clientSecret = "6DFUKtdNveO7oue7INvxKNc5B4VmUdVKE6Wue55f";

    public LoginRequest(String myEmail, String password) {
        this.myEmail = myEmail;
        this.password = password;
    }
}
