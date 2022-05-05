package com.example.appza.service.Training;

import com.example.appza.DTO.Coach.CoachResponse;
import com.example.appza.DTO.Training.TrainingCreateRequest;
import com.example.appza.DTO.Training.TrainingResponse;
import com.example.appza.DTO.Training.TrainingUpdateRequest;
import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.model.Training;
import com.example.appza.repository.BuildingRepository;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingService {


    private final TrainingRepository repo;
    private final SportService sportService;
    private final CoachService coachService;
    private final BuildingService buildingService;

    public Page<TrainingResponse> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Training> trainings = repo.findAll(pageable);

        var dto = trainings.get().map(this::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(dto);
    };
    public TrainingResponse getById(UUID id){
        return convertToDto(repo.getById(id));
    }

    public TrainingResponse create(TrainingCreateRequest training){
        Training training1 = Training.builder()
                .sport(sportService.getByIdOrd(training.getSport()))
                .coach(coachService.getByIdOrd(training.getCoachID()))
                .sportInfrastructure(buildingService.getByIdOrd(training.getSportInfrastructureID()))
                .id(UUID.randomUUID())
                .created_at(Date.valueOf(LocalDate.now()))
                .modified_at(Date.valueOf(LocalDate.now()))
                .build();
        return convertToDto(repo.save(training1));
    }

    public TrainingResponse update(TrainingUpdateRequest training){
        Training training1 = repo.getById(training.getId());
        training1.setCoach(coachService.getByIdOrd(training.getCoachID()));
        training1.setSport(sportService.getByIdOrd(training.getSport()));
        training1.setSportInfrastructure(buildingService.getByIdOrd(training.getSportInfrastructureID()));

        return convertToDto(repo.save(training1));

    }

    public String delete(UUID id){
        repo.deleteById(id);
        return "Training " + id + " deleted succesfully";
    }
    public TrainingResponse convertToDto(Training training){
        return TrainingResponse.builder()
                .id(training.getId())
                .coach(training.getCoach().getId())
                .sport(training.getSport().getId())
                .sportInfrastructure(training.getSportInfrastructure().getId())
                .build();

    }
}
