package com.example.appza.repository;

import com.example.appza.model.Building;
import com.example.appza.model.SportClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportClubRepository extends JpaRepository<SportClub, Long> {
}
