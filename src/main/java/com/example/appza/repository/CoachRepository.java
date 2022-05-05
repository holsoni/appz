package com.example.appza.repository;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoachRepository extends JpaRepository<Coach, UUID> {
}
