package com.example.APIJeuxOlympiques.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;



@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer quantity;
    private Float totalPrice;

    private Boolean status;

    private LocalDateTime date;
    public enum RoleUser{
        USER, ADMIN
    }
    @Enumerated(EnumType.STRING)
    private RoleUser role;

    // Constructors, getters, and setters

    public Ticket() {}

    public Ticket(Event event, User user, Integer quantity, Float totalPrice, Boolean status, LocalDateTime date) {
        this.event = event;
        this.user = user;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
