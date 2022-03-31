/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * com.sportinfrastucture.coursework.model.Training
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 01.04.21, 21:26
 *  * @Version Training.java : 1.0
 *
 */

package com.example.appza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name="training")
public class Training {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name="sport_id")
    private Sport sport;
    @OneToMany
    private List<Sportsmen> sportsmen;
    @ManyToOne
    @JoinColumn(name="coach_id")
    private Coach coach;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building sportInfrastructure;

    private Date created_at;
    private Date modified_at;
    private String description;

}
