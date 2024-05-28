package com.example.APIJeuxOlympiques.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
