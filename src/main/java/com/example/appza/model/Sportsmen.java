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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "sportsmen")
public class Sportsmen {
    @Id
    private Long id;
    private String name;
    private int year;
    @ManyToOne
    @JoinColumn(name="sportclub_id")
    private SportClub sportClub;
    @ManyToOne
    @JoinColumn(name="sport_id")
    private Sport sport;
    @ManyToOne
    @JoinColumn(name="degree_id")
    private Degree degree;

    private Date created_at;
    private Date modified_at;
    private String description;



}
