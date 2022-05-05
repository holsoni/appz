package com.example.appza.DTO.Coach;

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
public class CoachResponse {
    private UUID id;
    private String name;
    private int year;
    private UUID sportClubID;
}
