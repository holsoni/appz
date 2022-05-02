package com.example.appza.service;

import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.DegreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DegreeService {


    private final DegreeRepository repo;

    public Page<Degree> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    };
    public Degree getById(Long id){
        return repo.getById(id);
    }

    public Degree create(Degree degree){
        return repo.save(degree);
    }

    public Degree update(Degree degree){
        repo.deleteById(degree.getId());
        repo.save(degree);
        return degree;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Degree " + id + " deleted succesfully";
    }
}
