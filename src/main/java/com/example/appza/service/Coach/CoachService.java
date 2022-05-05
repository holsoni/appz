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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoachService {



    private final CoachRepository repo;
    private  final SportClubService sportClubService;

    public Page<CoachResponse> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Coach> coaches = repo.findAll(pageable);

        var coachesDto = coaches.get().map(this::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(coachesDto);
    };
    public CoachResponse getById(UUID id){
        return convertToDto(repo.getById(id));
    }
    public Coach getByIdOrd(UUID id){
        return repo.getById(id);
    }
    public CoachResponse create(CoachCreateRequest coach){
        Coach coach1 = Coach.builder()
                .name(coach.getName())
                .year(coach.getYear())
                .sportClub(sportClubService.getByIdOrd(coach.getSportClubID()))
                .id(UUID.randomUUID())
                .created_at(Date.valueOf(LocalDate.now()))
                .modified_at(Date.valueOf(LocalDate.now()))
                .build();

        return convertToDto(repo.save(coach1));
    }

    public CoachResponse update(CoachUpdateRequest coach){
        Coach coach1 = repo.getById(coach.getId());
        coach1.setSportClub(sportClubService.getByIdOrd(coach1.getSportClub().getId()));
        repo.deleteById(coach.getId());
        return convertToDto(repo.save(coach1));
    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "Coach " + id + " deleted succesfully";
    }

    public CoachResponse convertToDto(Coach coach){
        return CoachResponse.builder()
                .id(coach.getId())
                .name(coach.getName())
                .year(coach.getYear())
                .sportClubID(coach.getSportClub().getId())
                .build();

    }
}
