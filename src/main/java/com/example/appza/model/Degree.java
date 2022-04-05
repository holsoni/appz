/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * com.sportinfrastucture.coursework.model.Degree
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 01.04.21, 21:28
 *  * @Version Degree.java : 1.0
 *
 */

package com.example.appza.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Data
@Entity(name="degree")
public class Degree {
    @Id
    private Long id;
    private String degree;

}
