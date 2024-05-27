package com.example.APIJeuxOlympiques.user.register;

public class LoginDto {
    String mail;
    String password;

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
