package com.example.APIJeuxOlympiques.service;


import com.example.APIJeuxOlympiques.dto.RegistrationRequest;
import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.model.UserRole;
import com.example.APIJeuxOlympiques.response.RegisterResponse;
import com.example.APIJeuxOlympiques.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    public ResponseEntity<RegisterResponse> register(RegistrationRequest request){
        return userService.signUp(new User(
                request.getFullName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
        ));
    }

}
