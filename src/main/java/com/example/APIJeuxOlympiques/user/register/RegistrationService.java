package com.example.APIJeuxOlympiques.user.register;


import com.example.APIJeuxOlympiques.user.User;
import com.example.APIJeuxOlympiques.user.UserRole;
import com.example.APIJeuxOlympiques.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    public ResponseEntity<String> register(RegistrationRequest request){
        return userService.signUp(new User(
                request.getFullName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
        ));
    }

}
