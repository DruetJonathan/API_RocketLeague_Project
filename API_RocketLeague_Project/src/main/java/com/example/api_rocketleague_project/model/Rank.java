package com.example.api_rocketleague_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Table(name = "Rank")
public class Rank {
    private String name;
    @Enumerated(EnumType.STRING)
    private Ranks rank;
    @Enumerated(EnumType.STRING)
    private Divisions division;
}
