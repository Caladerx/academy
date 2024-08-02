package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.entity.TeamMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TeamService {
    @Inject
    TeamRepository teamRepository;

    @Transactional
    public void addTeam(TeamDTO teamDTO) {
        teamRepository.persist(TeamMapper.mapDtoToTeam(teamDTO));
    }

    public List<Team> getAllTeams() {
        return teamRepository.listAll();
    }

    public Team getTeamById(long id) {
        return teamRepository.findById(id);
    }

    @Transactional
    public void updateTeam(long id, TeamDTO teamDTO) {
        Team existingTeam = teamRepository.findById(id);
        if (existingTeam != null) {
            Team updatedTeam = TeamMapper.mapDtoToTeam(teamDTO);
            existingTeam.setName(updatedTeam.getName());
            existingTeam.setDefaultLocation(updatedTeam.getDefaultLocation());
            existingTeam.setProduct(updatedTeam.getProduct());
            teamRepository.persist(existingTeam);
        } else {
            throw new RuntimeException("Team not found");
        }
    }
}
