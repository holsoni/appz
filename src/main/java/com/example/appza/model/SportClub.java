package com.example.appza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name="sportclub")
public class SportClub {
    @Id
    private UUID id;
    private String creator;
    private String foundationYear;
    @OneToMany
    private List<Sport> specializations;
    private double rating;

    private Date created_at;
    private Date modified_at;
    private String description;

}
