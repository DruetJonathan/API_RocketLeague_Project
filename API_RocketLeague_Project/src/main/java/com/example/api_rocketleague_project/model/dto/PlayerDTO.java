package com.example.api_rocketleague_project.model.dto;

import com.example.api_rocketleague_project.model.entity.*;
import com.example.api_rocketleague_project.model.entity.enums.Plateforms;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class PlayerDTO {

    @NotBlank(message = "Le pseudo ne peut pas être vide et doit contenir entre {min} et {max} caractères.")
    @Size(min = 3, max = 32, message = "Le pseudo doit contenir entre {min} et {max} caractères.")
    private String pseudo;
    @NotEmpty(message = "La liste des ranks ne peut pas être vide")
    private List<Rank> ranks;
    @NotEmpty(message = "La plateforme ne peut pas être vide")
    private Plateforms plateform;
    @DecimalMin(value = "0", inclusive = true,message = "La valeur min est de {min}")
    private Integer wins;
    @DecimalMin(value = "0", inclusive = true,message = "La valeur min est de {min}")
    private Integer goals;
    @DecimalMin(value = "0", inclusive = true,message = "La valeur min est de {min}")
    private Integer assists;
    @DecimalMin(value = "0", inclusive = true,message = "La valeur min est de {min}")
    private Integer mvps;
    @DecimalMin(value = "0", inclusive = true,message = "La valeur min est de {min}")
    private Integer shots;
    @DecimalMin(value = "0", inclusive = true,message = "La valeur min est de {min}")
    private Integer saves;
    @NotEmpty(message = "L'id de la team ne peut pas être vide")
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
