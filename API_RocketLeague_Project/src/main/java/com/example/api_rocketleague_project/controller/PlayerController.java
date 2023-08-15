package com.example.api_rocketleague_project.controller;

import com.example.api_rocketleague_project.model.Player;
import com.example.api_rocketleague_project.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("/players")
    public ResponseEntity<List<Player>> getPlayers() {
        return ResponseEntity.status(200).body(this.playerService.getAll());
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayer(Long id) {
        return ResponseEntity.ok(this.playerService.getById(id));
    }

    @PostMapping("/player/modify/{id}")
    public ResponseEntity<Player> updatePlayer(Player player, @PathVariable Long id) {
        return ResponseEntity.ok(this.playerService.modify(player));
    }

    @PostMapping("/player/add")
//    AJOUTER @RequestBody P/
    /* Utilisation de l'annotation @RequestBody : Dans votre méthode de contrôleur API, ajoutez l'annotation @RequestBody avant le paramètre Player player pour indiquer à Spring d'extraire le corps de la requête HTTP et de mapper correctement les données JSON à l'objet Player.
     * */
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        System.out.println(player.toString());
        return ResponseEntity.ok(this.playerService.add(player));
    }

    @DeleteMapping("/player/delete/{id}")
    public ResponseEntity<Boolean> deletePlayer(Player player, @PathVariable Long id) {
        return ResponseEntity.ok(this.playerService.delete(player));
    }
}
