package com.example.APIJeuxOlympiques.service;

import com.example.APIJeuxOlympiques.dto.OrderTicketDto;
import com.example.APIJeuxOlympiques.model.Event;
import com.example.APIJeuxOlympiques.model.Ticket;
import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.repository.EventRepository;
import com.example.APIJeuxOlympiques.repository.TicketRepository;
import com.example.APIJeuxOlympiques.repository.UserRepository;
import com.example.APIJeuxOlympiques.response.OrderResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public ResponseEntity<OrderResponse> orderTicket(OrderTicketDto orderTicketDto) {
        Optional<Event> eventOptional = eventRepository.findById(orderTicketDto.getId_event());
        Optional<User> userOptional = userRepository.findById(orderTicketDto.getId_user());

        if (eventOptional.isEmpty() || userOptional.isEmpty()) {
            return new ResponseEntity<>(new OrderResponse("Please specify correct values", null), HttpStatus.BAD_REQUEST);
        }

        Event event = eventOptional.get();
        User user = userOptional.get();

        List<Ticket> userTickets = ticketRepository.findByUser(user);
        for (Ticket userTicket : userTickets) {
            if (userTicket.getEvent().getBeginDate().toLocalDate().equals(event.getBeginDate().toLocalDate())) {
                return new ResponseEntity<>(new OrderResponse("User already has a ticket for an event on this date", null), HttpStatus.CONFLICT);
            }
        }

        double finalPrice = orderTicketDto.getQuantity() * event.getPrice();
        if (orderTicketDto.getQuantity() >= 10) {
            finalPrice = finalPrice - (finalPrice * 0.1);
        }

        ticketRepository.save(new Ticket(event, user, orderTicketDto.getQuantity(), LocalDateTime.now(), finalPrice));
        return new ResponseEntity<>(new OrderResponse("Ticket ordered", finalPrice), HttpStatus.OK);
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

    public ResponseEntity<?> updateTicket(String ticketId, String eventId, String userId, int quantity, Double finalPrice) {
        logger.info("Finding ticket with ID: {}", ticketId);
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);

        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            logger.info("Ticket found: {}", ticket);

            Optional<Event> eventOptional = eventRepository.findById(eventId);
            if (eventOptional.isPresent()) {
                Event event = eventOptional.get();
                logger.info("Event found: {}", event);

                Optional<User> userOptional = userRepository.findById(userId);
                if (userOptional.isPresent()) {
                    User user = userOptional.get();
                    logger.info("User found: {}", user);

                    ticket.setEvent(event);
                    ticket.setUser(user);
                    ticket.setQuantity(quantity);
                    ticket.setFinalPrice(finalPrice);

                    ticketRepository.save(ticket);
                    logger.info("Ticket updated successfully: {}", ticket);
                    return new ResponseEntity<>("Ticket updated successfully", HttpStatus.OK);
                } else {
                    logger.error("User not found with ID: {}", userId);
                    return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
                }
            } else {
                logger.error("Event not found with ID: {}", eventId);
                return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
            }
        } else {
            logger.error("Ticket not found with ID: {}", ticketId);
            return new ResponseEntity<>("Ticket not found", HttpStatus.NOT_FOUND);
        }
    }
}
