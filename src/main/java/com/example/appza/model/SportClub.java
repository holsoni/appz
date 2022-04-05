package com.example.appza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name="sportclub")
public class SportClub {
    @Id
    private Long id;
    private String creator;
    private String foundationYear;
    @ManyToMany
    @JoinTable(name="sportclub_specializations",
            joinColumns=@JoinColumn (name="sportclub_id"),
            inverseJoinColumns=@JoinColumn(name="specialization_id"))
    private Set<Sport> specializations;
    private double rating;

    private Date created_at;
    private Date modified_at;
    private String description;

}
