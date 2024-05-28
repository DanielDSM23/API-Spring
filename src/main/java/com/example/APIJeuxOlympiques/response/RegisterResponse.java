package com.example.APIJeuxOlympiques.response;


import lombok.Getter;

@Getter
public class RegisterResponse {
    private final String api_key;
    private final String status;


    public RegisterResponse(String api_key, String status) {
        this.api_key = api_key;
        this.status = status;
    }
}
