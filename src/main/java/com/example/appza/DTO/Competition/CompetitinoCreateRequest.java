package com.example.appza.DTO.Competition;

import com.example.appza.model.Building;
import com.example.appza.model.Sport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitinoCreateRequest {

    private String name;
    private String sport;
    private String building;
    private String competitionOrganizer;
    private int events;

}
