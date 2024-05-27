package com.example.APIJeuxOlympiques.ticket;


import com.example.APIJeuxOlympiques.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class TicketController {
    private final TicketService ticketService;
    @Autowired
    private TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    @GetMapping
    public String test(){return "JSP";}
}
