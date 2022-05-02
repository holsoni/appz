package com.example.appza.service;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoachService {


    private final CoachRepository repo;

    public Page<Coach> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    };
    public Coach getById(Long id){
        return repo.getById(id);
    }

    public Coach create(Coach coach){
        return repo.save(coach);
    }

    public Coach update(Coach coach){
        repo.deleteById(coach.getId());
        repo.save(coach);
        return coach;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Coach " + id + " deleted succesfully";
    }
}
