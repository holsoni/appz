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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "competition")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Competition {
    @Id
    private UUID id;
    private String name;
    @ManyToOne
    private Sport sport;
    @ManyToOne
    private Building building;
    private String competitionOrganizer;
    private int events;

    private Date created_at;
    private Date modified_at;
    private String description;



}
