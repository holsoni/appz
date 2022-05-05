package com.example.appza.Stubs;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachStub {
    public static final Long ID = 1L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Coach getCoach(){
        return Coach.builder()
                .id(ID)
                .name("name1")
                .year(1999)
                .sportClub(null)
                .sport(null)
                .build();
    }

    public static List<Coach> getAll(){
        List<Coach> list = new ArrayList<>();
        Coach one =  Coach.builder()
                .id(ID)
                .name("name1")
                .year(1999)
                .sportClub(null)
                .sport(null)
                .build();
        Coach two =  Coach.builder()
                .id(2L)
                .name("name2")
                .year(1999)
                .sportClub(null)
                .sport(null)
                .build();
        list.add(one);
        list.add(two);
        return list;
    }
}
