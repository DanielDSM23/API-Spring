package com.example.APIJeuxOlympiques.controller;

import com.example.APIJeuxOlympiques.dto.OrderTicketDto;
import com.example.APIJeuxOlympiques.model.Ticket;
import com.example.APIJeuxOlympiques.response.OrderResponse;
import com.example.APIJeuxOlympiques.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<OrderResponse> orderTicket(@RequestBody OrderTicketDto orderTicketDto){
        return ticketService.orderTicket(orderTicketDto);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable String ticketId) {
        return ticketService.deleteTicket(ticketId);
    }
}
