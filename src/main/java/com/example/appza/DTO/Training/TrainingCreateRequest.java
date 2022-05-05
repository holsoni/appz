package com.example.appza.DTO.Training;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.model.Sport;
import com.example.appza.model.Sportsmen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TrainingCreateRequest {
    private UUID sport;
    private UUID coachID;
    private UUID sportInfrastructureID;


}
