package com.example.appza.service.Coach;

import com.example.appza.DTO.Coach.CoachCreateRequest;
import com.example.appza.DTO.Coach.CoachResponse;
import com.example.appza.DTO.Coach.CoachUpdateRequest;
import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.model.SportClub;
import com.example.appza.model.Sportsmen;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.CoachRepository;
import com.example.appza.service.SportClub.SportClubService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoachService {



    private final CoachRepository repo;

    public Page<Coach> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Optional<Coach> getById(Long id){
        return repo.findById(id);
    }

    public Coach create(Coach coach){
        return repo.save(coach);
    }

    public Coach update(Coach coach){
        repo.delete(coach);
        return repo.save(coach);

    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Coach " + id + " deleted succesfully";
    }
}
