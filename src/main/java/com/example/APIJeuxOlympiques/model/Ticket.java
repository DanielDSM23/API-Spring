package com.example.APIJeuxOlympiques.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;



@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
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
