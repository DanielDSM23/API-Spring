package com.example.APIJeuxOlympiques.service;


import com.example.APIJeuxOlympiques.dto.GetTicketsDto;
import com.example.APIJeuxOlympiques.dto.OrderTicketDto;
import com.example.APIJeuxOlympiques.model.Event;
import com.example.APIJeuxOlympiques.model.Ticket;
import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.repository.EventRepository;
import com.example.APIJeuxOlympiques.repository.TicketRepository;
import com.example.APIJeuxOlympiques.repository.UserRepository;
import com.example.APIJeuxOlympiques.response.OrderResponse;
import com.example.APIJeuxOlympiques.response.StatusReponse;
import com.example.APIJeuxOlympiques.security.config.AuthService;
import com.example.APIJeuxOlympiques.security.config.JwtService;
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
    private final AuthService authenticationService;
    private final UserRepository userRepo;
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;

    private final JwtService jwtService;

    public ResponseEntity<OrderResponse> addOrder(OrderTicketDto orderTicketDto){
        Optional<Event> event = eventRepository.findById(orderTicketDto.getId_event());
        Optional<User> user = userRepo.findById(orderTicketDto.getId_user());
        boolean isEventExisting = event.isPresent();
        boolean isUserExisting = user.isPresent();
        if(isEventExisting && isUserExisting){
            double finalPrice = orderTicketDto.getQuantity() * event.get().getPrice();
            if(orderTicketDto.getQuantity() >=10){ //reduction in case of lot of quanitity
                finalPrice = finalPrice - (finalPrice * 0.1);
            }
            ticketRepository.save(new Ticket(event.get(), user.get(), orderTicketDto.getQuantity(), LocalDateTime.now(),finalPrice));
            return new ResponseEntity<>(new OrderResponse("Ticket ordered", finalPrice), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new OrderResponse("Please specify correct values", null), HttpStatus.OK);
        }
    }

    public List<Ticket> getAllOrders(){
        return ticketRepository.findAll();
    }

    public ResponseEntity<?> deleteOrder(String id){
        ticketRepository.deleteById(id);
        if(ticketRepository.findById(id).isPresent()){
            return new ResponseEntity<>(new StatusReponse("Error"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new StatusReponse("Element deleted with success"), HttpStatus.OK);

    }
}
