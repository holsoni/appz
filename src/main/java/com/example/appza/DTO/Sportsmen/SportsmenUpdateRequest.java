package com.example.appza.DTO.Sportsmen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportsmenUpdateRequest {
    private UUID id;
    private String name;
    private UUID sportClubID;
    private UUID sportID;
    private UUID degreeID;

}
