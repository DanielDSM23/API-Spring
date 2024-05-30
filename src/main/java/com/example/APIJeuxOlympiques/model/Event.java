package com.example.APIJeuxOlympiques.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String eventName;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Boolean status;
    private String place;
    private Double price;

    @OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "event-stadium")
    private List<Stadium> stadiums = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "event-ticket")
    private List<Ticket> tickets = new ArrayList<>();

    public Event(String eventName, LocalDateTime beginDate, LocalDateTime endDate, Boolean status, String place) {
        this.eventName = eventName;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.place = place;
    }

    public Event() {
    }
}
