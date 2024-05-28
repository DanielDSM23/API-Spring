package com.example.APIJeuxOlympiques.controller;


import com.example.APIJeuxOlympiques.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stadium")
public class StadiumController {
    private final StadiumService stadiumService;
    @Autowired
    private StadiumController(StadiumService stadiumService){
        this.stadiumService = stadiumService;
    }
}
