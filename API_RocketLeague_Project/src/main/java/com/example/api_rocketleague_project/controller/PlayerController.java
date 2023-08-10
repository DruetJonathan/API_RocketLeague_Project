package com.example.api_rocketleague_project.controller;

import com.example.api_rocketleague_project.model.Player;
import com.example.api_rocketleague_project.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("GET")
@RestController
public class PlayerController {
    PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @RequestMapping("/players")
    public ResponseEntity<List<Player>> getPlayers(){
        return ResponseEntity.status(200).body(this.playerService.getAll());
    }
    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayer(Long id){
        return ResponseEntity.ok(this.playerService.getById(id));
    }
    @PostMapping("/player/modify/{id}")
    public ResponseEntity<Player> updatePlayer(Player player,@PathVariable Long id){
        return ResponseEntity.ok(this.playerService.modify(player));
    }
    @PostMapping("/player/add")
    public ResponseEntity<Player> addPlayer(Player player){
        return ResponseEntity.ok(this.playerService.add(player));
    }
    @DeleteMapping("/player/delete/{id}")
    public ResponseEntity<Boolean> deletePlayer(Player player,@PathVariable Long id){
        return ResponseEntity.ok(this.playerService.delete(player));
    }
}
