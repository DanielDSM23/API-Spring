package com.example.APIJeuxOlympiques.repository;

import com.example.APIJeuxOlympiques.model.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Transactional()
@Repository
public interface EventRepository extends JpaRepository<Event, String> {

}