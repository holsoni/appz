package com.example.appza.repository;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    Coach findCoachByName(String name);
    @Query(value = "SELECT * FROM coach WHERE year = 1999",
            nativeQuery = true)
     Coach findByYear(int year);
}
