package com.example.api_rocketleague_project.model.entity;

import com.example.api_rocketleague_project.model.entity.enums.Divisions;
import com.example.api_rocketleague_project.model.entity.enums.Ranks;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Table(name = "Rank")
public class Rank {
    @Enumerated(EnumType.STRING)
    private Ranks rank;
    @Enumerated(EnumType.STRING)
    private Divisions division;
}
