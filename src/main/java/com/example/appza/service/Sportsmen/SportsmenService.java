package com.example.appza.service.Sportsmen;

import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.DTO.Sportsmen.SportsmenCreateRequest;
import com.example.appza.DTO.Sportsmen.SportsmenResponse;
import com.example.appza.DTO.Sportsmen.SportsmenUpdateRequest;
import com.example.appza.model.Building;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import com.example.appza.model.Sportsmen;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.SportRepository;
import com.example.appza.repository.SportsmenRepository;
import com.example.appza.service.Degree.DegreeService;
import com.example.appza.service.Sport.SportService;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportsmenService {


    private final SportsmenRepository repo;
    private final SportService sportService;
    private final SportClubService sportClubService;
    private final DegreeService degreeService;


    public Page<SportsmenResponse> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Page<Sportsmen> sportsmen = repo.findAll(pageable);

        var sportsmenDto = sportsmen.get().map(this::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(sportsmenDto);
    };
    public SportsmenResponse getById(UUID id){
        return convertToDto(repo.getById(id));
    }

    public SportsmenResponse create(SportsmenCreateRequest sportsmen){
        Sportsmen sportsmen1 = Sportsmen.builder()
                .name(sportsmen.getName())
                .year(sportsmen.getYear())
                .sportClub(sportClubService.getByIdOrd(sportsmen.getSportClubID()))
                .sport(sportService.getByIdOrd(sportsmen.getSportID()))
                .degree(degreeService.getByIdOrd(sportsmen.getDegreeID()))
                .id(UUID.randomUUID())
                .created_at(Date.valueOf(LocalDate.now()))
                .modified_at(Date.valueOf(LocalDate.now()))
                .build();

        return convertToDto(repo.save(sportsmen1));
    }

    public SportsmenResponse update(SportsmenUpdateRequest sportsmen){
        Sportsmen sportsmen1 = repo.getById(sportsmen.getId());
        sportsmen1.setName(sportsmen.getName());
        sportsmen1.setSportClub(sportClubService.getByIdOrd(sportsmen.getSportClubID()));
        sportsmen1.setSport(sportService.getByIdOrd(sportsmen.getSportID()));
        sportsmen1.setDegree(degreeService.getByIdOrd(sportsmen.getDegreeID()));

        return convertToDto(repo.save(sportsmen1));
    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "Sportsmen " + id + " deleted succesfully";
    }

    public SportsmenResponse convertToDto(Sportsmen sportsmen){
        return SportsmenResponse.builder()
                .id(sportsmen.getId())
                .name(sportsmen.getName())
                .year(sportsmen.getYear())
                .sport(sportsmen.getSport().getId())
                .sportClubName(sportsmen.getSportClub().getId())
                .degree(sportsmen.getDegree().getId())
                .build();
    }
}
