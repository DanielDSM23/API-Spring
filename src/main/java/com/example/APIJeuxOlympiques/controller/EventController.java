package com.example.APIJeuxOlympiques.controller;


import com.example.APIJeuxOlympiques.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/event")
public class EventController {
    private final EventService eventService;
    @Autowired
    private EventController(EventService eventService){
        this.eventService = eventService;
    }
}
