/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * com.sportinfrastucture.coursework.model.Competition
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 01.04.21, 21:24
 *  * @Version Competition.java : 1.0
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
public class Competition {
    @Id
    private String id;
    private String name;
    private Sport sport;
    private Building building;
    private CompetitionOrganizer competitionOrganizer;
    private int events;

    private Date createdAt;
    private Date modifiedAt;
    private String description;


}
