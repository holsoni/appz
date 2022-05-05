package com.example.appza.DTO.Building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BuildingUpdateRequest {
    private UUID id;
    private String name;
    private String address;
}
