package com.example.api_rocketleague_project.controller;

import com.example.api_rocketleague_project.model.dto.PlayerDTO;
import com.example.api_rocketleague_project.model.entity.Player;
import com.example.api_rocketleague_project.service.PlayerService;
import com.example.api_rocketleague_project.service.TeamService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@Slf4j
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;


    public PlayerController(
            PlayerService playerService,
            TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @RequestMapping("/players")
    public ResponseEntity<List<Player>> getPlayers() {
        return ResponseEntity.status(200).body(this.playerService.getAll());
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        Player player = playerService.getById(id);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/player/modify/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody @Valid PlayerDTO playerDTO, @PathVariable Long id) {
        return ResponseEntity.ok(this.playerService.save(playerDTO.toEntity()));
    }

    @PostMapping("/player/add")
    /* Utilisation de l'annotation @RequestBody : Dans votre méthode de contrôleur API,
    ajoutez l'annotation @RequestBody avant le paramètre Player player pour indiquer
    à Spring d'extraire le corps de la requête HTTP et de mapper correctement les données
    JSON à l'objet Player.
    */
    public ResponseEntity<Player> addPlayer(@RequestBody @Valid PlayerDTO toAdd) {
        Player player = toAdd.toEntity();
        player.setTeam( teamService.getById( toAdd.getTeamId() ));
        return ResponseEntity.ok(this.playerService.save(player));
    }

    @DeleteMapping("/player/delete/{id}")
    public ResponseEntity<Boolean> deletePlayer(@RequestBody @Valid PlayerDTO playerDTO, @PathVariable Long id) {
        return ResponseEntity.ok(this.playerService.delete(playerDTO.toEntity()));
    }
}
