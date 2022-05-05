package com.example.appza.Stubs;

import com.example.appza.model.Building;
import com.example.appza.model.Sport;
import com.example.appza.model.Training;

import java.util.ArrayList;
import java.util.List;

public class TrainingStub {
    public static final Long ID = 1L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Training getTraining(){
        return Training.builder()
                .id(ID)
                .description("description")
                .build();
    }

    public static List<Training> getAll(){
        List<Training> list = new ArrayList<>();
        Training one =  Training.builder()
                .id(ID)
                .description("description")
                .build();
        Training two =  Training.builder()
                .id(ID)
                .description("description")
                .build();
        list.add(one);
        list.add(two);
        return list;
    }
}
