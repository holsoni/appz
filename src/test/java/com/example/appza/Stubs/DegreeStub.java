package com.example.appza.Stubs;

import com.example.appza.model.Building;
import com.example.appza.model.Competition;
import com.example.appza.model.Degree;

import java.util.ArrayList;
import java.util.List;

public class DegreeStub {
    public static final Long ID = 1L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Degree getDegree(){
        return Degree.builder()
                .id(ID)
                .degree("degree")
                .build();
    }


    public static List<Degree> getAll(){
        List<Degree> list = new ArrayList<>();
        Degree one =  Degree.builder()
                .id(ID)
                .degree("degree")
                .build();
        Degree two =  Degree.builder()
                .id(ID)
                .degree("degree")
                .build();
        list.add(one);
        list.add(two);
        return list;
    }
}
