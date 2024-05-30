package com.example.APIJeuxOlympiques.controller;


import com.example.APIJeuxOlympiques.model.Event;
import com.example.APIJeuxOlympiques.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/event")
public class EventController {
    private final EventService eventService;
    @Autowired
    private EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }

    @GetMapping("/{id}")
    public Optional<Event> getEvent(@PathVariable String id){
        return eventService.getEventById(id);
    }

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @PutMapping("{id}")
    public Event updateEvent(@PathVariable String id, @RequestBody Event event){
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable String id) {
        String message = eventService.deleteEvent(id);
        return ResponseEntity.ok(message);
    }
}