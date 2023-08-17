package com.example.api_rocketleague_project.service;

import com.example.api_rocketleague_project.Exception.DeletionFailedException;
import com.example.api_rocketleague_project.Exception.RessourceNotFoundException;
import com.example.api_rocketleague_project.model.entity.Player;
import com.example.api_rocketleague_project.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
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
        return this.playerRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("player",id));
    }
    @Override
    @Transactional
    public Player save(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    @Transactional
    public boolean delete(Player player) {
        try {
            this.playerRepository.delete(player);
        }catch (DeletionFailedException e){
            throw new DeletionFailedException(player.getPseudo(),player.getId());
        }
        return true;
    }
    @Override
    public List<Player> getAllPlayersById(Long[] ids){
        return this.playerRepository.findAllById(List.of(ids));
    }
}
