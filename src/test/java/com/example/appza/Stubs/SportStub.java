package com.example.appza.Stubs;

import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import com.example.appza.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportStub {
    public static final Long ID = 1L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Sport getSport(){
        return Sport.builder()
                .id(ID)
                .sport("sport")
                .build();
    }

    public static List<Sport> getAll(){
        List<Sport> list = new ArrayList<>();
        Sport one =  Sport.builder()
                .id(ID)
                .sport("sport")
                .build();
        Sport two =  Sport.builder()
                .id(ID)
                .sport("sport1")
                .build();
        list.add(one);
        list.add(two);
        return list;
    }
}
