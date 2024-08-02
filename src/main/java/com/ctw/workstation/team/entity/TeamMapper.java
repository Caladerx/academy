package com.ctw.workstation.team.entity;

import java.time.LocalDateTime;

public class TeamMapper {

    public static TeamDTO mapTeamToDto(Team team) {
        return new TeamDTO(team.getName(), team.getProduct(), team.getDefaultLocation());
    }

    public static Team mapDtoToTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setProduct(teamDTO.getProduct());
        team.setDefaultLocation(teamDTO.getDefaultLocation());
        team.setCreatedAt(LocalDateTime.now());
        team.setModifiedAt(LocalDateTime.now());
        return team;
    }
}
