/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * com.sportinfrastucture.coursework.model.Sportsmen
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 01.04.21, 21:11
 *  * @Version Sportsmen.java : 1.0
 *
 */

package com.example.appza.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Sportsmen {

    private String id;
    private String name;
    private int year;
    private SportClub sportClub;
    private Sport sport;
    private Degree degree;

    private Date createdAt;
    private Date modifiedAt;
    private String description;

    public Sportsmen(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
