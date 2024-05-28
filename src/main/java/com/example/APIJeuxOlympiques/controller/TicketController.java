package com.example.APIJeuxOlympiques.controller;


import com.example.APIJeuxOlympiques.dto.OrderTicketDto;
import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.response.OrderResponse;
import com.example.APIJeuxOlympiques.response.RegisterResponse;
import com.example.APIJeuxOlympiques.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ticket")
public class TicketController {
    private final TicketService ticketService;
    @Autowired
    private TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    @GetMapping
    public String test(){return "Test Route";}

    @PostMapping
    public ResponseEntity<OrderResponse> orderTicket(@RequestBody OrderTicketDto orderTicketDto){
        return ticketService.addOrder(orderTicketDto);
    }

}
