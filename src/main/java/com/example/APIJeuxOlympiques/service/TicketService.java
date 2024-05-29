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

    public ResponseEntity<OrderResponse> orderTicket(OrderTicketDto orderTicketDto){
        Optional<Event> event = eventRepository.findById(orderTicketDto.getId_event());
        Optional<User> user = userRepository.findById(orderTicketDto.getId_user());
        boolean isEventExisting = event.isPresent();
        boolean isUserExisting = user.isPresent();
        if(isEventExisting && isUserExisting){
            double finalPrice = orderTicketDto.getQuantity() * event.get().getPrice();
            if(orderTicketDto.getQuantity() >=10){ //reduction in case of lot of quanitity
                finalPrice = finalPrice - (finalPrice * 0.1);
            }
            ticketRepository.save(new Ticket(event.get(), user.get(), orderTicketDto.getQuantity(), LocalDateTime.now(),finalPrice));
            return new ResponseEntity<OrderResponse>(new OrderResponse("Ticket ordered", finalPrice), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<OrderResponse>(new OrderResponse("Please specify correct values", null), HttpStatus.OK);
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
