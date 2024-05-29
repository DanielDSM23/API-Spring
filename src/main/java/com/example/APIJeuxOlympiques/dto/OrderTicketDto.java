package com.example.APIJeuxOlympiques.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderTicketDto {
    private String id_ticket;
    private String id_user;
    private String id_event;
    private Double final_price;
    private int quantity;
}
