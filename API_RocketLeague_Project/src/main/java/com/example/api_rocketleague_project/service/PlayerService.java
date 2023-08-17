package com.example.api_rocketleague_project.service;


import com.example.api_rocketleague_project.model.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    List<Player> getAll();
    Player getById(Long id);
    Player add(Player player);
    Player modify(Player player);
    boolean delete(Player player);
}
