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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name="training")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue()
    private Long id;
    @ManyToOne
    @JoinColumn(name="sport_id")
    private Sport sport;
    @ManyToMany
    @JoinTable(name="sportsman_training",
            joinColumns=@JoinColumn(name="training_id"),
            inverseJoinColumns=@JoinColumn(name="sportsman_id"))
    private Set<Sportsmen> sportsmen;
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
