package com.example.appza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SportClub {
    private String id;
    private String creator;
    private String foundationYear;
    private List<Sport> specializations;
    private double rating;

    private Date createdAt;
    private Date modifiedAt;
    private String description;

}
