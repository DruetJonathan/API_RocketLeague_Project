package com.example.api_rocketleague_project.model.dto;

import com.example.api_rocketleague_project.model.entity.Player;
import com.example.api_rocketleague_project.model.entity.Team;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TeamDTO {
    @NotBlank(message = "Le nom de la team ne peut pas être vide")
    @Size(min = 3, max = 32, message = "Le pseudo doit contenir entre {min} et {max} caractères.")
    private String teamName;

    @NotNull(message = "La liste des joueurs ne peut pas être nulle")
    private Long[] players;

    @NotNull(message = "L'ID du capitaine ne peut pas être nul")
    private Long captain;


    public Team toEntity(){
        Team team = new Team();
        team.setTeamName(this.getTeamName());
        // ajout des players et du capitains en mode player dans le controller
        return team;
    }
}
