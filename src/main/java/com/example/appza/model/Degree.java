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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;
@Data
@Entity(name="degree")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Degree {
    @Id
    @GeneratedValue()
    private Long id;
    private String degree;

    private Date created_at;
    private Date modified_at;
    private String description;
}
