package com.example.APIJeuxOlympiques.service;

import com.example.APIJeuxOlympiques.model.Event;
import com.example.APIJeuxOlympiques.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
@Service
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        logger.info("Creating event: {}", event);
        Event savedEvent = eventRepository.save(event);
        logger.info("Event created: {}", savedEvent);
        return savedEvent;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(String id, Event eventDetails) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setEventName(eventDetails.getEventName());
                    event.setBeginDate(eventDetails.getBeginDate());
                    event.setEndDate(eventDetails.getEndDate());
                    event.setStatus(eventDetails.getStatus());
                    event.setPlace(eventDetails.getPlace());
                    event.setPrice(eventDetails.getPrice());
                    return eventRepository.save(event);
                }).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
