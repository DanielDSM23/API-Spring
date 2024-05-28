package com.example.APIJeuxOlympiques.model;

import jakarta.persistence.*;


@Entity
@Table(name = "stadium")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String location;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event events;

}
