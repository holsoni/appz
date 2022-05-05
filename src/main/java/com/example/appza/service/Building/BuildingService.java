package com.example.appza.service.Building;

import com.example.appza.DTO.Building.BuildingCreateRequest;
import com.example.appza.DTO.Building.BuildingResponse;
import com.example.appza.DTO.Building.BuildingUpdateRequest;
import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.model.Building;
import com.example.appza.model.SportClub;
import com.example.appza.repository.BuildingRepository;
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
public class BuildingService {


    private final BuildingRepository repo;

    public Page<BuildingResponse> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Building> buildings = repo.findAll(pageable);

        var buildingsDto = buildings.get().map(this::convertToDto).collect(Collectors.toList());

        return new PageImpl<>(buildingsDto);
    };
    public BuildingResponse getById(UUID id){
        return convertToDto(repo.getById(id));
    }
    public Building getByIdOrd(UUID id){
        return repo.getById(id);
    }

    public BuildingResponse create(BuildingCreateRequest building){
        Building building1 = Building.builder()
                .name(building.getName())
                .address(building.getAddress())
                .id(UUID.randomUUID())
                .created_at(Date.valueOf(LocalDate.now()))
                .modified_at(Date.valueOf(LocalDate.now()))
                .build();
        return convertToDto(repo.save(building1));
    }

    public BuildingResponse update(BuildingUpdateRequest building){
        Building building1 = repo.getById(building.getId());
        building1.setName(building.getName());
        return convertToDto(repo.save(building1));

    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "Building " + id + " deleted succesfully";
    }

    public BuildingResponse convertToDto(Building building){
        return BuildingResponse.builder()
                .id(building.getId())
                .name(building.getName())
                .address(building.getAddress())
                .build();
    }
}
