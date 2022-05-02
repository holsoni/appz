package com.example.appza.repository;

import com.example.appza.model.Building;
import com.example.appza.model.Sportsmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsmenRepository extends JpaRepository<Sportsmen, Long> {
}