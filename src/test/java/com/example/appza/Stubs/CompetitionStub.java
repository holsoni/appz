package com.example.appza.Stubs;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.model.Competition;

import java.util.ArrayList;
import java.util.List;

public class CompetitionStub {
    public static final Long ID = 1L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Competition getCompetition(){
        return Competition.builder()
                .id(ID)
                .name("competition")
                .competitionOrganizer("organizer")
                .events(5)
                .build();
    }

    public static List<Competition> getAll(){
        List<Competition> list = new ArrayList<>();
        Competition one =  Competition.builder()
                .id(ID)
                .name("competition")
                .competitionOrganizer("organizer")
                .events(5)
                .build();
        Competition two =  Competition.builder()
                .id(2L)
                .name("competition2")
                .competitionOrganizer("organizer2")
                .events(15)
                .build();
        list.add(one);
        list.add(two);
        return list;
    }
}
