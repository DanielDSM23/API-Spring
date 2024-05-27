package com.example.APIJeuxOlympiques.user.register;


import com.example.APIJeuxOlympiques.user.UserService;
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
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

}
