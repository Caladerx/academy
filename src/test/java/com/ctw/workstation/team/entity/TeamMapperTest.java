package com.ctw.workstation.team.entity;

import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import static org.junit.jupiter.api.Assertions.*;

class TeamMapperTest {

    @Test
    void mapTeamToDto() {
        //Arrange
        Team team = new Team();
        team.setProduct("ProductA");
        team.setName("TeamNameA");
        team.setDefaultLocation("Lisbon");
        //Act
        TeamDTO teamDTO = TeamMapper.mapTeamToDto(team);
        //Assert
        assertAll(
                () -> assertEquals(team.getName(), teamDTO.getName()),
                () -> assertEquals(team.getProduct(), teamDTO.getProduct()),
                () -> assertEquals(team.getDefaultLocation(), teamDTO.defaultLocation())
        );
    }

    @Test
    void mapDtoToTeam() {
        //Arrange
        TeamDTO teamDTO = new TeamDTO("TeamNameA", "ProductA", "Porto");
        //Act
        Team team = TeamMapper.mapDtoToTeam(teamDTO);
        //Assert
        assertAll(
                () -> assertEquals(teamDTO.getName(), team.getName()),
                () -> assertEquals(teamDTO.getProduct(), team.getProduct()),
                () -> assertEquals(teamDTO.defaultLocation(), team.getDefaultLocation())
        );
    }
}