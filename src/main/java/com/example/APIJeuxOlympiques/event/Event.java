package com.example.APIJeuxOlympiques.event;

import jakarta.persistence.Entity;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Entity
public class Event {
    private Long id;
    private String eventName;

    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Boolean status;
    private String place;
}
