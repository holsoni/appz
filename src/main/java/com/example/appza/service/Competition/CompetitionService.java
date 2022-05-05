package com.example.appza.service.Competition;

import com.example.appza.model.Building;
import com.example.appza.model.Competition;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompetitionService {


    private final CompetitionRepository repo;

    public Page<Competition> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }

    public Competition getById(UUID id){
        return repo.getById(id);
    }

    public Competition create(Competition competition){
        return repo.save(competition);
    }

    public Competition update(Competition competition){
        repo.deleteById(competition.getId());
        repo.save(competition);
        return competition;
    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "Competition " + id + " deleted succesfully";
    }
}
