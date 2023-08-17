package com.example.api_rocketleague_project.controller;


import com.example.api_rocketleague_project.Exception.RessourceNotFoundException;
import com.example.api_rocketleague_project.model.dto.TeamDTO;
import com.example.api_rocketleague_project.model.entity.Player;
import com.example.api_rocketleague_project.model.entity.Team;
import com.example.api_rocketleague_project.service.PlayerService;
import com.example.api_rocketleague_project.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TeamController {
    TeamService teamService;
    PlayerService playerService;
    public TeamController(TeamService teamService,PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getTeams() {
        return ResponseEntity.ok(this.teamService.getAll());
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id) {
        Team team = teamService.getById(id);
        if (team != null) {
            return ResponseEntity.ok(this.teamService.getById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/team/modify/{id}")
    public ResponseEntity<Team> updateTeam(@RequestBody @Valid Team team, @PathVariable Long id) {
        return ResponseEntity.ok(this.teamService.save(team));
    }

    @PostMapping("/team/add")
//    AJOUTER @RequestBody P/
    /* Utilisation de l'annotation @RequestBody : Dans votre méthode de contrôleur API, ajoutez l'annotation @RequestBody avant le paramètre Player player pour indiquer à Spring d'extraire le corps de la requête HTTP et de mapper correctement les données JSON à l'objet Player.
     * */
    public ResponseEntity<Team> addTeam(@RequestBody @Valid TeamDTO toAdd) {
        Team team = new Team();
        team.setCaptain(this.playerService.getById(toAdd.getCaptain()));
//        List<Player> players = new ArrayList<>();
//        for (Long idPlayer : toAdd.getPlayers()) {
//            Player byId = this.playerService.getById(idPlayer);
//            if (byId != null){
//                players.add(byId);
//            }
//            else{
//                throw new RessourceNotFoundException("Ressouce non trouvée");
//            }
//        }
        team.setPlayers(this.playerService.getAllPlayersById(toAdd.getPlayers()));
        return ResponseEntity.ok(this.teamService.save(toAdd.toEntity()));
    }

    @DeleteMapping("/team/delete/{id}")
    public ResponseEntity<Boolean> deleteTeam(@RequestBody @Valid TeamDTO team, @PathVariable Long id) {
        return ResponseEntity.ok(this.teamService.delete(team.toEntity()));
    }

}
