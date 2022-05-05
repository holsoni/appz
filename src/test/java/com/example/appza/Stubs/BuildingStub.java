package com.example.appza.Stubs;

import com.example.appza.DTO.Building.BuildingCreateRequest;
import com.example.appza.DTO.Building.BuildingUpdateRequest;
import com.example.appza.model.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BuildingStub {
    public static final Long ID = 3L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Building getRandomBuilding(){
        return Building.builder()
                .id(ID)
                .name("string")
                .address("string")
                .build();
    }

    public static List<Building> getAll(){
        List<Building> buildingList = new ArrayList<>();
        Building one =  Building.builder()
                .id(ID)
                .name("string")
                .address("string")
                .build();
        Building two =  Building.builder()
                .id(2L)
                .name("two")
                .address("two")
                .build();
    buildingList.add(one);
    buildingList.add(two);
    return buildingList;
    }
}
