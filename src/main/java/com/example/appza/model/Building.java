/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * edu.coursework.sportinfrastructure.model.Building
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 07.06.21, 21:02
 *  * @Version Building.java : 1.0
 *
 */

package com.example.appza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "buildings")
public class Building {

    @Id
    private Long id;
    private String name;
    private String address;

    private Date created_at;
    private Date modified_at;
    private String description;

}
