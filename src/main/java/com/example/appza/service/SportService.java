package com.example.appza.service;

import com.example.appza.model.Building;
import com.example.appza.model.Sport;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.SportClubRepository;
import com.example.appza.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportService {


    private final SportRepository repo;

    public Page<Sport> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    };
    public Sport getById(Long id){
        return repo.getById(id);
    }

    public Sport create(Sport sport){
        return repo.save(sport);
    }

    public Sport update(Sport sport){
        repo.deleteById(sport.getId());
        repo.save(sport);
        return sport;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Sport " + id + " deleted succesfully";
    }
}
