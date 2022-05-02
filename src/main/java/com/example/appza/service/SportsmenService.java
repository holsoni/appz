package com.example.appza.service;

import com.example.appza.model.Building;
import com.example.appza.model.Sportsmen;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.SportRepository;
import com.example.appza.repository.SportsmenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportsmenService {


    private final SportsmenRepository repo;

    public Page<Sportsmen> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    };
    public Sportsmen getById(Long id){
        return repo.getById(id);
    }

    public Sportsmen create(Sportsmen sportsmen){
        return repo.save(sportsmen);
    }

    public Sportsmen update(Sportsmen sportsmen){
        repo.deleteById(sportsmen.getId());
        repo.save(sportsmen);
        return sportsmen;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Sportsmen " + id + " deleted succesfully";
    }
}
