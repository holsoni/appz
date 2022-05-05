package com.example.appza.DTO.Coach;

import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CoachCreateRequest {
    private String name;
    private int year;
    private UUID sportClubID;
}
