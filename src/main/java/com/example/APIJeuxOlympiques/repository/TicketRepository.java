package com.example.APIJeuxOlympiques.repository;

import com.example.APIJeuxOlympiques.model.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional()
@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {


}