package com.example.api_rocketleague_project.service;

import com.example.api_rocketleague_project.model.Team;
import com.example.api_rocketleague_project.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    TeamRepository teamRepository;
    @Override
    public List<Team> getAll() {
        return this.teamRepository.findAll();
    }

    @Override
    public Team getById(Long id) {
        return this.teamRepository.findById(id).get();
    }

    @Override
    public Team add(Team team) {
        return this.teamRepository.save(team);
    }

    @Override
    public Team modify(Team team) {
        return this.teamRepository.save(team);
    }

    @Override
    public boolean delete(Team team) {
        try {
            teamRepository.delete(team);
        }catch (RuntimeException e){
            return false;
        }
        return true;
    }
}
