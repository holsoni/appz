package com.example.appza.service.Sportsmen;

import com.example.appza.DTO.Mapper;
import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.DTO.Sportsmen.SportsmenCreateRequest;
import com.example.appza.DTO.Sportsmen.SportsmenResponse;
import com.example.appza.DTO.Sportsmen.SportsmenUpdateRequest;
import com.example.appza.DTO.SportsmenInfoDTO;
import com.example.appza.model.Building;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import com.example.appza.model.Sportsmen;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.SportClubRepository;
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
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportsmenService {


    private final SportsmenRepository repo;
    private final Mapper mapper;
    public Page<Sportsmen> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Optional<SportsmenInfoDTO> getById(Long id){
        Optional<Sportsmen> sportsmen = repo.findById(id);
        return Optional.of(mapper.mapToSportsmenInfoDTO(sportsmen));

    }

    public Sportsmen create(Sportsmen sportsmen){
        return repo.save(sportsmen);
    }

    public Sportsmen update(Sportsmen sportsmen){
        repo.delete(sportsmen);
        return repo.save(sportsmen);

    }

    public String delete(Long id){
        repo.deleteById(id);
        return "SportClub " + id + " deleted succesfully";
    }
}
