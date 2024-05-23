package com.example.APIJeuxOlympiques.user;

import jakarta.persistence.Entity;

import java.util.List;
@Entity
public class User {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private List<Ticket>;

}
