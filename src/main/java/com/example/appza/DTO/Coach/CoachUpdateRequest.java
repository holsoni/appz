package com.example.appza.DTO.Coach;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CoachUpdateRequest {
    private UUID id;
    private UUID sportClubID;
}
