package com.example.APIJeuxOlympiques.response;


import lombok.Getter;

@Getter
public class SignInResponse {
    private String api_key;

    public SignInResponse(String api_key) {
        this.api_key = api_key;
    }
}
