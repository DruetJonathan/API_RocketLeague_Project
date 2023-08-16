package com.example.api_rocketleague_project.repository;

import com.example.api_rocketleague_project.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
