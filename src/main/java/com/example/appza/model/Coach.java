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


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name = "coach")
public class Coach {
    @Id
    private UUID id;
    private String name;
    private int year;
    @OneToMany
    private List<Sport> sport;
    @ManyToOne
    private SportClub sportClub;

    private Date created_at;
    private Date modified_at;
    private String description;

}
