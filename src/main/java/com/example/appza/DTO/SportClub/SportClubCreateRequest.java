package com.example.appza.DTO.SportClub;

import com.example.appza.model.Sport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportClubCreateRequest {
    private String name;
    private String creator;
    private String foundationYear;
    private double rating;
}
