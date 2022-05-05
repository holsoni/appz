package com.example.appza.service.Competition;

import com.example.appza.model.Competition;
import com.example.appza.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionService {


    private final CompetitionRepository repo;

    public Page<Competition> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }

    public Optional<Competition> getById(Long id){
        return repo.findById(id);
    }

    public Competition create(Competition competition){
        return repo.save(competition);
    }

    public Competition update(Competition competition){
        repo.deleteById(competition.getId());
        repo.save(competition);
        return competition;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Competition " + id + " deleted succesfully";
    }
}
