package com.example.api_rocketleague_project.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Player captain;
}