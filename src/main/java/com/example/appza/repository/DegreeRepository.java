package com.example.appza.repository;

import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
