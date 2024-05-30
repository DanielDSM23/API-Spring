package com.example.APIJeuxOlympiques.repository;

import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findByUser(User user);
}
