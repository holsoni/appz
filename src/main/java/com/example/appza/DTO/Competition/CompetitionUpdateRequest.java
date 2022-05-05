package com.example.appza.DTO.Competition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionUpdateRequest {
    private String id;
    private String name;
    private String sport;
    private String building;
    private String competitionOrganizer;
    private int events;

}
