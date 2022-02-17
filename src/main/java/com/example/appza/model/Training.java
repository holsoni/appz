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

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Training {
    private String id;
    private Sport sport;
    private List<Sportsmen> sportsmen;
    private Coach coach;
    private Building sportInfrastructure;

    private Date createdAt;
    private Date modifiedAt;
    private String description;

}
