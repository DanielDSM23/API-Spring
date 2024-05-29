package com.example.APIJeuxOlympiques.response;

import lombok.Getter;

@Getter
public class StatusReponse {
    public StatusReponse(String status) {
        this.status = status;
    }

    private String status;
}
