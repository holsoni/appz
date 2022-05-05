package com.example.appza.service.Degree;

import com.example.appza.DTO.Degree.DegreeCreateRequest;
import com.example.appza.DTO.Degree.DegreeResponse;
import com.example.appza.DTO.Degree.DegreeUpdateRequest;
import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.model.*;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.CoachRepository;
import com.example.appza.repository.DegreeRepository;
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
public class DegreeService {

    private final DegreeRepository repo;

    public Page<Degree> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Optional<Degree> getById(Long id){
        return repo.findById(id);
    }

    public Degree create(Degree degree){
        return repo.save(degree);
    }

    public Degree update(Degree degree){
        repo.delete(degree);
        return repo.save(degree);

    }

    public String delete(Long id){
        repo.deleteById(id);
        return "CoDegreeach " + id + " deleted succesfully";
    }

}
