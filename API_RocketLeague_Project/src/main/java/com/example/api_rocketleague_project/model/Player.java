package com.example.api_rocketleague_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pseudo;

    private Integer elo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id")
    private Rank rank;

    private Plateforms plateform;

    private String image;

    private Integer wins;
    private Integer goals;
    private Integer assists;
    private Integer mvps;
    private Integer shots;
    private Integer saves;


}
