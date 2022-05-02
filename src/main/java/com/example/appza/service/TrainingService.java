package com.example.appza.service;

import com.example.appza.model.Building;
import com.example.appza.model.Training;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService {


    private final TrainingRepository repo;

    public Page<Training> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    };
    public Training getById(Long id){
        return repo.getById(id);
    }

    public Training create(Training training){
        return repo.save(training);
    }

    public Training update(Training training){
        repo.deleteById(training.getId());
        repo.save(training);
        return training;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Training " + id + " deleted succesfully";
    }
}
