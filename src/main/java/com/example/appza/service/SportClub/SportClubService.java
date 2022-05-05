package com.example.appza.service.SportClub;

import com.example.appza.DTO.SportClub.SportClubCreateRequest;
import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.DTO.SportClub.SportClubUpdateRequest;
import com.example.appza.model.Building;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import com.example.appza.repository.BuildingRepository;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportClubService {


    private final SportClubRepository repo;

    public Page<SportClubResponse> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Page<SportClub> sportClubs = repo.findAll(pageable);

        var sportClubsDto = sportClubs.get().map(this::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(sportClubsDto);
    };
    public SportClubResponse getById(UUID id){
        return convertToDto(repo.getById(id));
    }

    public SportClub getByIdOrd(UUID id){
        return repo.getById(id);
    }

    public SportClubResponse create(SportClubCreateRequest sportClub){
        SportClub sportClub1 = SportClub.builder()
                .name(sportClub.getName())
                .creator(sportClub.getCreator())
                .foundationYear(sportClub.getFoundationYear())
                .rating(sportClub.getRating())
                .id(UUID.randomUUID())
                .created_at(Date.valueOf(LocalDate.now()))
                .modified_at(Date.valueOf(LocalDate.now()))
                .build();
        return convertToDto(repo.save(sportClub1));
    }

    public SportClubResponse update(SportClubUpdateRequest sportClub){
        SportClub sportClub1 = repo.getById(sportClub.getId());
        sportClub1.setName(sportClub.getName());
        sportClub1.setRating(sportClub.getRating());
        return convertToDto(repo.save(sportClub1));
    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "SportClub " + id + " deleted succesfully";
    }

    public SportClubResponse convertToDto(SportClub sportClub){
        return SportClubResponse.builder()
                .id(sportClub.getId())
                .name(sportClub.getName())
                .creator(sportClub.getCreator())
                .foundationYear(sportClub.getFoundationYear())
                .rating(sportClub.getRating())
                .build();
    }
}
