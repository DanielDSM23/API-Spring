package com.example.APIJeuxOlympiques.controller;


import com.example.APIJeuxOlympiques.dto.GetTicketsDto;
import com.example.APIJeuxOlympiques.dto.OrderTicketDto;
import com.example.APIJeuxOlympiques.model.Ticket;
import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.response.OrderResponse;
import com.example.APIJeuxOlympiques.response.RegisterResponse;
import com.example.APIJeuxOlympiques.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticket")
public class TicketController {
    private final TicketService ticketService;
    @Autowired
    private TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> orderTicket(@RequestBody OrderTicketDto orderTicketDto){
        return ticketService.addOrder(orderTicketDto);
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTicket(){
        return ticketService.getAllOrders();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTicket(@RequestBody OrderTicketDto orderTicketDto){
        return ticketService.deleteOrder(orderTicketDto.getId_ticket());
    }


}
