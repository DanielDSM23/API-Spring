package com.example.APIJeuxOlympiques.repository;

import com.example.APIJeuxOlympiques.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, String> {
}
