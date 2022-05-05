package com.example.appza.service.Degree;

import com.example.appza.DTO.Degree.DegreeCreateRequest;
import com.example.appza.DTO.Degree.DegreeResponse;
import com.example.appza.DTO.Degree.DegreeUpdateRequest;
import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import com.example.appza.repository.BuildingRepository;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DegreeService {


    private final DegreeRepository repo;

    public Page<DegreeResponse> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Page<Degree> degrees = repo.findAll(pageable);

        var degreesDto = degrees.get().map(this::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(degreesDto);
    };
    public DegreeResponse getById(UUID id){
        return convertToDto(repo.getById(id));
    }
    public Degree getByIdOrd(UUID id){
        return repo.getById(id);
    }

    public DegreeResponse create(DegreeCreateRequest degree){
        Degree degree1 = Degree.builder()
                .degree(degree.getDegree())
                .id(UUID.randomUUID())
                .created_at(Date.valueOf(LocalDate.now()))
                .modified_at(Date.valueOf(LocalDate.now()))
                .build();
        return convertToDto(repo.save(degree1));

    }

    public DegreeResponse update(DegreeUpdateRequest degree){
        Degree degree1 = repo.getById(degree.getId());
        degree1.setDegree(degree.getDegree());
        return convertToDto(repo.save(degree1));

    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "Degree " + id + " deleted succesfully";
    }

    public DegreeResponse convertToDto(Degree degree){
        return DegreeResponse.builder()
                .id(degree.getId())
                .degree(degree.getDegree())
                .build();
    }

}
