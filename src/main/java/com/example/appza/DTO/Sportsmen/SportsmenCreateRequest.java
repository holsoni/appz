package com.example.appza.DTO.Sportsmen;

import com.example.appza.model.Degree;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportsmenCreateRequest {
    private String name;
    private int year;
    private UUID sportClubID;
    private UUID sportID;
    private UUID degreeID;

}
