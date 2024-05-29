package com.example.APIJeuxOlympiques.controller;

import com.example.APIJeuxOlympiques.model.Stadium;
import com.example.APIJeuxOlympiques.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    @Autowired
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @PostMapping
    public Stadium createStadium(@RequestBody Stadium stadium) {
        return stadiumService.createStadium(stadium);
    }

    @GetMapping("/{id}")
    public Optional<Stadium> getStadium(@PathVariable String id) {
        return stadiumService.getStadiumById(id);
    }

    @GetMapping
    public List<Stadium> getAllStadiums() {
        return stadiumService.getAllStadiums();
    }

    @PutMapping("/{id}")
    public Stadium updateStadium(@PathVariable String id, @RequestBody Stadium stadium) {
        return stadiumService.updateStadium(id, stadium);
    }

    @DeleteMapping("/{id}")
    public void deleteStadium(@PathVariable String id) {
        stadiumService.deleteStadium(id);
    }
}
