package com.example.appza.service.SportClub;

import com.example.appza.DTO.SportClub.SportClubCreateRequest;
import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.DTO.SportClub.SportClubUpdateRequest;
import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.DegreeRepository;
import com.example.appza.repository.SportClubRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportClubService {

    private final SportClubRepository repo;

    public Page<SportClub> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Optional<SportClub> getById(Long id){
        return repo.findById(id);
    }

    public SportClub create(SportClub sportClub){
        return repo.save(sportClub);
    }

    public SportClub update(SportClub sportClub){
        repo.delete(sportClub);
        return repo.save(sportClub);

    }

    public String delete(Long id){
        repo.deleteById(id);
        return "SportClub " + id + " deleted succesfully";
    }
}
