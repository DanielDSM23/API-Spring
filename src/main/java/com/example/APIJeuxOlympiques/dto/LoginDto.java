package com.example.APIJeuxOlympiques.dto;


public class LoginDto {
    private String mail;
    private String password;

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
