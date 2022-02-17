/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * com.sportinfrastucture.coursework.model.Coach
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 01.04.21, 21:11
 *  * @Version Coach.java : 1.0
 *
 */

package com.example.appza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coach {
    @Id
    private String id;
    private String name;
    private int year;
    private Sport sport;
    private SportClub sportClub;

    private Date createdAt;
    private Date modifiedAt;
    private String description;

    public Coach(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getSportClubName(){
        return sportClub.getName();
    }
}
