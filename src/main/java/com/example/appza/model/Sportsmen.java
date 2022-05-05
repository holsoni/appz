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

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "sportsmen")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sportsmen {
    @Id
    @GeneratedValue()
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
