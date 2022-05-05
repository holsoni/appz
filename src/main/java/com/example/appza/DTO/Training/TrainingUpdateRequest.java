package com.example.appza.DTO.Training;

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
public class TrainingUpdateRequest {
    private UUID id;
    private UUID sport;
    private UUID coachID;
    private UUID sportInfrastructureID;


}
