package com.example.appza.DTO.Training;

import com.example.appza.DTO.Building.BuildingResponse;
import com.example.appza.DTO.Coach.CoachResponse;
import com.example.appza.DTO.Sport.SportResponse;
import com.example.appza.model.Sport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TrainingResponse {
    private UUID id;
    private UUID sport;
    private UUID coach;
    private UUID sportInfrastructure;

}
