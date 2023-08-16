package com.example.api_rocketleague_project.controller;


import com.example.api_rocketleague_project.model.Player;
import com.example.api_rocketleague_project.model.Team;
import com.example.api_rocketleague_project.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TeamController {
    TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @RequestMapping("/teams")
    public ResponseEntity<List<Team>> getPlayers() {
        return ResponseEntity.status(200).body(this.teamService.getAll());
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<Team> getTeam(Long id) {
        return ResponseEntity.ok(this.teamService.getById(id));
    }

    @PostMapping("/team/modify/{id}")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team, @PathVariable Long id) {
        return ResponseEntity.ok(this.teamService.modify(team));
    }

    @PostMapping("/team/add")
//    AJOUTER @RequestBody P/
    /* Utilisation de l'annotation @RequestBody : Dans votre méthode de contrôleur API, ajoutez l'annotation @RequestBody avant le paramètre Player player pour indiquer à Spring d'extraire le corps de la requête HTTP et de mapper correctement les données JSON à l'objet Player.
     * */
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        System.out.println(team.toString());
        return ResponseEntity.ok(this.teamService.add(team));
    }

    @DeleteMapping("/team/delete/{id}")
    public ResponseEntity<Boolean> deleteTeam(Team team, @PathVariable Long id) {
        return ResponseEntity.ok(this.teamService.delete(team));
    }

}
