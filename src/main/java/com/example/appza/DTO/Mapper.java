package com.example.appza.DTO;

import com.example.appza.model.Coach;
import com.example.appza.model.SportClub;
import com.example.appza.model.Sportsmen;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Mapper {
    public SportsmenInfoDTO mapToSportsmenInfoDTO(Optional<Sportsmen> sportsmen){
        SportsmenInfoDTO sportsmenInfoDTO = new SportsmenInfoDTO();

        sportsmenInfoDTO.setId(sportsmen.get().getId());
        sportsmenInfoDTO.setName(sportsmen.get().getName());
        sportsmenInfoDTO.setYear(sportsmen.get().getYear());
        sportsmenInfoDTO.setSport(sportsmen.get().getSport().getSport());
        sportsmenInfoDTO.setSportClub(sportsmen.get().getSportClub().getName());
        sportsmenInfoDTO.setDegree(sportsmen.get().getDegree().getDegree());

        return sportsmenInfoDTO;
    }
}
