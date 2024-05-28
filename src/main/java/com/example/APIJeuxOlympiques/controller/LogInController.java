package com.example.APIJeuxOlympiques.controller;


import com.example.APIJeuxOlympiques.response.SignInResponse;
import com.example.APIJeuxOlympiques.service.UserService;
import com.example.APIJeuxOlympiques.dto.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
@AllArgsConstructor
public class LogInController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<SignInResponse> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

}
