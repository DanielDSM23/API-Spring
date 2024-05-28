package com.example.APIJeuxOlympiques.controller;


import com.example.APIJeuxOlympiques.dto.RegistrationRequest;
import com.example.APIJeuxOlympiques.response.RegisterResponse;
import com.example.APIJeuxOlympiques.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/register")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegisterResponse> register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }



}
