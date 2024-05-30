package com.example.APIJeuxOlympiques.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stadium")
@Getter
@Setter
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String location;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonBackReference(value = "event-stadium")
    private Event events;
}
