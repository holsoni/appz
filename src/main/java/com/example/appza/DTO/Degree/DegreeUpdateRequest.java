package com.example.appza.DTO.Degree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DegreeUpdateRequest {
    private UUID id;
    private String degree;
}