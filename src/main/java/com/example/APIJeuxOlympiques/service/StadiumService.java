package com.example.APIJeuxOlympiques.service;

import com.example.APIJeuxOlympiques.model.Stadium;
import com.example.APIJeuxOlympiques.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public Stadium createStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public Optional<Stadium> getStadiumById(String id) {
        return stadiumRepository.findById(id);
    }

    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    public Stadium updateStadium(String id, Stadium stadiumDetails) {
        return stadiumRepository.findById(id)
                .map(stadium -> {
                    stadium.setName(stadiumDetails.getName());
                    stadium.setLocation(stadiumDetails.getLocation());
                    stadium.setCapacity(stadiumDetails.getCapacity());
                    stadium.setEvents(stadiumDetails.getEvents());
                    return stadiumRepository.save(stadium);
                }).orElseThrow(() -> new RuntimeException("Stadium not found"));
    }

    public void deleteStadium(String id) {
        stadiumRepository.deleteById(id);
    }
}
