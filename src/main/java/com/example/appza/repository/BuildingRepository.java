package com.example.appza.repository;

import com.example.appza.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
}
