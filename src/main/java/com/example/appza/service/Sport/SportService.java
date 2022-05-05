package com.example.appza.service.Sport;

import com.example.appza.DTO.Degree.DegreeCreateRequest;
import com.example.appza.DTO.Degree.DegreeResponse;
import com.example.appza.DTO.Degree.DegreeUpdateRequest;
import com.example.appza.DTO.Sport.SportCreateRequest;
import com.example.appza.DTO.Sport.SportResponse;
import com.example.appza.DTO.Sport.SportUpdateRequest;
import com.example.appza.DTO.SportClub.SportClubCreateRequest;
import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.DegreeRepository;
import com.example.appza.repository.SportClubRepository;
import com.example.appza.repository.SportRepository;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportService {


    private final SportRepository repo;

    public Page<Sport> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Optional<Sport> getById(Long id){
        return repo.findById(id);
    }

    public Sport create(Sport sport){
        return repo.save(sport);
    }

    public Sport update(Sport sport){
        repo.delete(sport);
        return repo.save(sport);
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "sport " + id + " deleted succesfully";
    }
}
