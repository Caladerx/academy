package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@QuarkusTest
class RackResourceTest {
    private static final Jsonb JSONB = JsonbBuilder.create();

    @InjectMock
    private RackService mockRackService;
    @Inject
    RackResource rackResource;

    static Rack rack;
    static Team team;

    @BeforeAll
    static void setUp() {
        prepareTestTeam();
        prepareTestRack();
    }

    @BeforeEach
    void beforeEach(){
        rackResource.updateRackById(51L, rack);
    }


    @Test
    void addRackReturnsOkResponse() {
        //Arrange
        //Act
        int responseCode = rackResource.addRack(rack).getStatus();
        //Assert
        assertEquals(201, responseCode);
    }

    @Test
    void getAllRacks() {
        //Arrange
        List<Rack> rackList = new ArrayList<>();
        rackList.add(rack);
        //Act
        int responseCode = rackResource.getAllRacks().getStatus();
        //Assert
        assertEquals(200, responseCode);
    }

    @Test
    void getRackByIdReturnsOkResponse() {
        //Arrange
        when(mockRackService.getRackById(1L)).thenReturn(rack);
        //Act
        int responseCode = rackResource.getRackById(1L).getStatus();
        //Assert
        assertEquals(200, responseCode);
    }

    @Test
    void getRackByIdReturnsNotFoundResponse() {
        //Arrange
        //Act
        int responseCode = rackResource.getRackById(1L).getStatus();
        //Assert
        assertEquals(404, responseCode);
    }

    @Test
    void deleteRackById() {
    }

    @Test
    void getRacksByStatus() {
    }

    @Test
    void testAddRack() {
    }

    @Test
    void testGetAllRacks() {
    }

    @Test
    void testGetRackById() {
    }

    @Test
    void testUpdateRackById() {
    }

    @Test
    void testDeleteRackById() {
    }

    @Test
    void testGetRacksByStatus() {
    }

    static void prepareTestRack() {
        rack = new Rack();
        rack.setTeam(team);
        rack.setTeamId(team.getId());
        rack.setDefaultLocation(team.getDefaultLocation());
        rack.setSerialNumber("12345");
        rack.setStatus(Status.AVAILABLE);
    }

    static void prepareTestTeam() {
        team = new Team();
        team.setDefaultLocation("Lisbon");
        team.setName("Name");
        team.setProduct("Product");
        team.setId(1L);
    }
}