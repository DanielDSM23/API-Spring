package com.example.APIJeuxOlympiques.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }
}
