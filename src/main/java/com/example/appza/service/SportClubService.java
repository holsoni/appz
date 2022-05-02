package com.example.appza.service;

import com.example.appza.model.Building;
import com.example.appza.model.SportClub;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.SportClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportClubService {


    private final SportClubRepository repo;

    public Page<SportClub> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    };
    public SportClub getById(Long id){
        return repo.getById(id);
    }

    public SportClub create(SportClub sportClub){
        return repo.save(sportClub);
    }

    public SportClub update(SportClub sportClub){
        repo.deleteById(sportClub.getId());
        repo.save(sportClub);
        return sportClub;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "SportClub " + id + " deleted succesfully";
    }
}
