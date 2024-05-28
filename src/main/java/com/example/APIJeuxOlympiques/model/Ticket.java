package com.example.APIJeuxOlympiques.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;



    private Integer quantity;

    private LocalDateTime date;

    private Double finalPrice;


    public Ticket() {}

    public Ticket(Event event, User user, Integer quantity, LocalDateTime date, Double finalPrice) {
        this.event = event;
        this.user = user;
        this.quantity = quantity;
        this.date = date;
        this.finalPrice = finalPrice;
    }

}
