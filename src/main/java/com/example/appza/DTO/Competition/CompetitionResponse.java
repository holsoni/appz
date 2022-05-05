package com.example.appza.DTO.Competition;

import com.example.appza.DTO.Building.BuildingResponse;
import com.example.appza.DTO.Sport.SportResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionResponse {
    private String id;
    private String name;
    private Long sport;
    private Long building;
    private String competitionOrganizer;
    private int events;

}
