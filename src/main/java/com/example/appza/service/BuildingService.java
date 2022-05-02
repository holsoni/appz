package com.example.appza.service;

import com.example.appza.model.Building;
import com.example.appza.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuildingService {


    private final BuildingRepository repo;

    public Page<Building> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    };
    public Building getById(Long id){
        return repo.getById(id);
    }

    public Building create(Building building){
        return repo.save(building);
    }

    public Building update(Building building){
        repo.deleteById(building.getId());
        repo.save(building);
        return building;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Building " + id + " deleted succesfully";
    }
}
