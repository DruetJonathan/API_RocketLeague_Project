package com.example.api_rocketleague_project.service;

import com.example.api_rocketleague_project.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    List<Team> getAll();
    Team getById(Long id);
    Team add(Team team);
    Team modify(Team team);
    boolean delete(Team team);
}
