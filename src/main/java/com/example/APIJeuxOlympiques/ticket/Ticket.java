package com.example.APIJeuxOlympiques.ticket;

import com.example.APIJeuxOlympiques.user.User;

import java.time.LocalDateTime;

public class Ticket {

    private Long id;
    private Event event;
    private User user;

    private int quantity;
    private Float totalPrice;

    private Boolean status;

    private LocalDateTime Date;


}
