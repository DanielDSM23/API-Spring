package com.example.APIJeuxOlympiques.ticket;

import com.example.APIJeuxOlympiques.event.Event;
import com.example.APIJeuxOlympiques.user.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Event event;

    @ManyToOne
    private User user;

    private int quantity;
    private Float totalPrice;

    private Boolean status;

    private LocalDateTime Date;


}
