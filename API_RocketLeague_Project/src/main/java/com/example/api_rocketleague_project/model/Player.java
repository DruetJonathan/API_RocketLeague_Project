package com.example.api_rocketleague_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pseudo;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ranks_list_id")
    @ElementCollection
    private List<Rank> ranks;
    private Plateforms plateform;
    private String image;
    private Integer wins;
    private Integer goals;
    private Integer assists;
    private Integer mvps;
    private Integer shots;
    private Integer saves;

}
