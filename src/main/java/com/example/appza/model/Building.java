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
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
public class Building {

    private String id;
    private String name;
    private String address;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
