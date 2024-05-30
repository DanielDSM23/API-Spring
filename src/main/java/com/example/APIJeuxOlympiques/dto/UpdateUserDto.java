package com.example.APIJeuxOlympiques.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateUserDto {
    private String fullName;
    private String email;
    private String password;
}
