package com.example.APIJeuxOlympiques.controller;

import com.example.APIJeuxOlympiques.model.Stadium;
import com.example.APIJeuxOlympiques.service.StadiumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/stadium")
public class StadiumController {

    private static final Logger logger = LoggerFactory.getLogger(StadiumController.class);
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
    public ResponseEntity<String> deleteStadium(@PathVariable String id) {
        String message = stadiumService.deleteStadium(id);
        if (message.equals("Stadium deleted successfully")) {
            logger.info("Stadium with ID {} deleted successfully", id);
            return ResponseEntity.ok(message);
        } else {
            logger.warn("Stadium with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
