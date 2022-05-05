package com.example.appza.DTO.SportClub;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportClubResponse {
    private UUID id;
    private String name;
    private String creator;
    private String foundationYear;
    private double rating;
}
