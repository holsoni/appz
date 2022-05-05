package com.example.appza.DTO;

import com.example.appza.model.Degree;
import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;
@Data
public class SportsmenInfoDTO {
    private Long id;
    private String name;
    private int year;
    private String sportClub;
    private String sport;
    private String degree;

}
