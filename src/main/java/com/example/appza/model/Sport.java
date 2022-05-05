/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * com.sportinfrastucture.coursework.model.Sport
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 01.04.21, 21:27
 *  * @Version Sport.java : 1.0
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
@Entity(name = "sport")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sport {
    @Id
    private UUID id;
    private String sport;

    private Date created_at;
    private Date modified_at;
    private String description;
}
