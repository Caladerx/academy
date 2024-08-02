package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.Team;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@QuarkusTest
@ExtendWith(MockitoExtension.class)
class TeamResourceTest {

    @InjectMock
    private TeamService mockTeamService;

    @Inject
    TeamResource teamResource;

    static Team team;

    @BeforeAll
    static void setup() {
        team = new Team();
        team.setDefaultLocation("Lisbon");
        team.setName("Name");
        team.setProduct("Product");
        team.setId(1L);
    }

    @Test
    void getTeamsReturnsOkResponse() {
        //Arrange
        List<Team> list = new ArrayList<>();
        list.add(team);
        when(mockTeamService.getAllTeams()).thenReturn(list);
        //Act
        Response response = teamResource.getTeams();
        // Assert
        assertEquals(200, response.getStatus());
    }

    @ParameterizedTest
    @MethodSource("teamArguments")
    void getTeamByIdReturnsOkOrNotFoundResponse(Integer expected, Long id) {
        //Arrange
        when(mockTeamService.getTeamById(1L)).thenReturn(team);

        //Act
        Response response = teamResource.getTeamById(id);
        // Assert
        assertEquals(expected, response.getStatus());
    }


    static Stream<Arguments> teamArguments() {
        return Stream.of(
                Arguments.arguments(200, 1L),
                Arguments.arguments(404, 2L),
                Arguments.arguments(404, 3L)
        );
    }
}

