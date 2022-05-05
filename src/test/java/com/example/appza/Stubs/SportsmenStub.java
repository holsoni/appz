package com.example.appza.Stubs;

import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import com.example.appza.model.Sportsmen;

import java.util.ArrayList;
import java.util.List;

public class SportsmenStub {
    public static final Long ID = 1L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Sportsmen getSportsmen(){
        return Sportsmen.builder()
                .id(ID)
                .name("string")
                .year(2002)
                .build();
    }

    public static List<Sportsmen> getAll(){
        List<Sportsmen> list = new ArrayList<>();
        Sportsmen one =  Sportsmen.builder()
                .id(ID)
                .name("string")
                .year(2002)
                .build();
        Sportsmen two =  Sportsmen.builder()
                .id(ID)
                .name("string")
                .year(2002)
                .build();
        list.add(one);
        list.add(two);
        return list;
    }
}
