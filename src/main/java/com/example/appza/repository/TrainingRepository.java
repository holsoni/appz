package com.example.appza.repository;

import com.example.appza.model.Building;
import com.example.appza.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrainingRepository extends JpaRepository<Training, UUID> {
}
