package com.example.APIJeuxOlympiques.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public void addUser(@RequestBody User user){
        if(!userService.addNewUser(user)){
           throw new RuntimeException("Email taken by another account"); //TODO 201
        }
    }

    @DeleteMapping
    public void removeUser(@RequestBody User user) {
        if(!userService.deleteAccount(user)){
            throw new RuntimeException("The account does not exist");// TODO 201
        }
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        if(!userService.editAccount(user)){
            throw new RuntimeException("The account does not exist");// TODO 201
        }
    }

}
