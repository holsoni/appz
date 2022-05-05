package com.example.appza.Stubs;

import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;

import java.util.ArrayList;
import java.util.List;

public class SportClubStub {
    public static final Long ID = 1L;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static SportClub getSportClub(){
        return SportClub.builder()
                .id(ID)
                .creator("creator")
                .foundationYear("1978")
                .name("name")
                .rating(7.8)
                .build();
    }

    public static List<SportClub> getAll(){
        List<SportClub> list = new ArrayList<>();
        SportClub one =  SportClub.builder()
                .id(ID)
                .creator("creator")
                .foundationYear("1978")
                .name("name")
                .rating(7.8)
                .build();
        SportClub two =  SportClub.builder()
                .id(2L)
                .creator("creator2")
                .foundationYear("1988")
                .name("name2")
                .rating(5.2)
                .build();
        list.add(one);
        list.add(two);
        return list;
    }
}
