package com.example.APIJeuxOlympiques.response;


import lombok.Getter;

@Getter
public class OrderResponse {
    private final String status;
    private final Double price;

    public OrderResponse(String status, Double price) {
        this.status = status;
        this.price = price;
    }
}
