package com.example.api_rocketleague_project.service;

import com.example.api_rocketleague_project.model.Player;
import com.example.api_rocketleague_project.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{
    PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player getById(Long id) {
        return this.playerRepository.findById(id).get();
    }

    @Override
    public Player add(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    public Player modify(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    public boolean delete(Player player) {
        try {
            this.playerRepository.delete(player);
        }catch (RuntimeException e){
            return false;
        }
        return true;
    }
}
