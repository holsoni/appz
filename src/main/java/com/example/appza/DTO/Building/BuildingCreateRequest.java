package com.example.appza.DTO.Building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BuildingCreateRequest {
    private String name;
    private String address;
}
