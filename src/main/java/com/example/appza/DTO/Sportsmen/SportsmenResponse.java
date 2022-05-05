package com.example.appza.DTO.Sportsmen;

import com.example.appza.DTO.Degree.DegreeResponse;
import com.example.appza.DTO.Sport.SportResponse;
import com.example.appza.DTO.SportClub.SportClubResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportsmenResponse {
    private UUID id;
    private String name;
    private int year;
    private UUID sportClubName;
    private UUID sport;
    private UUID degree;

}
