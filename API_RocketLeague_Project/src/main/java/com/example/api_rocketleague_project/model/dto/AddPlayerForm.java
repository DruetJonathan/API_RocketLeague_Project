package com.example.api_rocketleague_project.model.dto;

import com.example.api_rocketleague_project.model.entity.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class AddPlayerForm {


    private String pseudo;
    @NotEmpty
    private List<Rank> ranks;
    private Plateforms plateform;
    private Integer wins;
    private Integer goals;
    private Integer assists;
    private Integer mvps;
    private Integer shots;
    private Integer saves;
    private Long teamId;

    public Player toEntity(){
        Player player = new Player();
        player.setPseudo(this.getPseudo());
        player.setRanks(this.getRanks());
        player.setPlateform(this.getPlateform());
        player.setWins(this.getWins());
        player.setGoals(this.getGoals());
        player.setAssists(this.getAssists());
        player.setMvps(this.getMvps());
        player.setShots(this.getShots());
        player.setSaves(this.getSaves());

        return player;
    }


}
