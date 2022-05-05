package com.example.appza.service.Training;

import com.example.appza.DTO.Coach.CoachResponse;
import com.example.appza.DTO.Training.TrainingCreateRequest;
import com.example.appza.DTO.Training.TrainingResponse;
import com.example.appza.DTO.Training.TrainingUpdateRequest;
import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.model.SportClub;
import com.example.appza.model.Training;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.SportClubRepository;
import com.example.appza.repository.TrainingRepository;
import com.example.appza.service.Building.BuildingService;
import com.example.appza.service.Coach.CoachService;
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
public class TrainingService {

    private final TrainingRepository repo;

    public Page<Training> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Optional<Training> getById(Long id){
        return repo.findById(id);
    }

    public Training create(Training training){
        return repo.save(training);
    }

    public Training update(Training training){
        repo.delete(training);
        return repo.save(training);

    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Training " + id + " deleted succesfully";
    }
}
