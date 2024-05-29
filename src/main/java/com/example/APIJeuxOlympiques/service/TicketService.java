package com.example.APIJeuxOlympiques.service;

import com.example.APIJeuxOlympiques.model.Event;
import com.example.APIJeuxOlympiques.model.Ticket;
import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.repository.EventRepository;
import com.example.APIJeuxOlympiques.repository.TicketRepository;
import com.example.APIJeuxOlympiques.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> createTicket(String eventId, String userId, int quantity, Double finalPrice) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (eventOptional.isPresent() && userOptional.isPresent()) {
            Event event = eventOptional.get();
            User user = userOptional.get();
            Ticket ticket = new Ticket(event, user, quantity, LocalDateTime.now(), finalPrice);
            ticketRepository.save(ticket);
            return new ResponseEntity<>("Ticket created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Event or user not found", HttpStatus.NOT_FOUND);
        }
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public ResponseEntity<?> deleteTicket(String ticketId) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            ticketRepository.deleteById(ticketId);
            return new ResponseEntity<>("Ticket deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ticket not found", HttpStatus.NOT_FOUND);
        }
    }
}
