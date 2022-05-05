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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportService {


    private final SportRepository repo;

    public Page<SportResponse> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Page<Sport> sports = repo.findAll(pageable);

        var sportsDto = sports.get().map(this::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(sportsDto);
    };
    public SportResponse getById(UUID id){
        return convertToDto(repo.getById(id));
    }
    public Sport getByIdOrd(UUID id){
        return repo.getById(id);
    }

    public SportResponse create(SportCreateRequest sport){
        Sport sport1 = Sport.builder()
                .id(UUID.randomUUID() )
                .sport(sport.getSport())
                .created_at(Date.valueOf(LocalDate.now()))
                .modified_at(Date.valueOf(LocalDate.now()))
                .build();
        return convertToDto(repo.save(sport1));

    }

    public SportResponse update(SportUpdateRequest sport){
        Sport sport1 = repo.getById(sport.getId());
        sport1.setSport(sport.getSport());
        return convertToDto(repo.save(sport1));

    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "Sport " + id + " deleted succesfully";
    }
    public SportResponse convertToDto(Sport sport){
        return SportResponse.builder()
                .id(sport.getId())
                .sport(sport.getSport())
                .build();
    }
}
