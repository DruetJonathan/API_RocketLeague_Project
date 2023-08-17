package com.example.api_rocketleague_project.service;

import com.example.api_rocketleague_project.Exception.DeletionFailedException;
import com.example.api_rocketleague_project.Exception.RessourceNotFoundException;
import com.example.api_rocketleague_project.model.entity.Player;
import com.example.api_rocketleague_project.model.entity.Team;
import com.example.api_rocketleague_project.repository.PlayerRepository;
import com.example.api_rocketleague_project.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    TeamRepository teamRepository;
    PlayerRepository playerRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAll() {
        return this.teamRepository.findAll();
    }

    @Override
    public Team getById(Long id) {
        return this.teamRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("team",id));
    }

    @Override
    @Transactional
    public Team save(Team team) {
        return this.teamRepository.save(team);
    }


    @Override
    @Transactional
    public boolean delete(Team team) {
        try {
            teamRepository.delete(team);
        }catch (DeletionFailedException e){
            throw new DeletionFailedException(team.getTeamName(),team.getId());
        }
        return true;
    }

}
