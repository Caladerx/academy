package com.ctw.workstation.team.boundary;

import com.ctw.workstation.DatabaseTestResource;
import com.ctw.workstation.team.entity.TeamDTO;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@QuarkusTest
@QuarkusTestResource(DatabaseTestResource.class)
public class TeamResourceEndpointTest {

    @Test
    void getAllTeamsEndpoint() {
        given()
                .when()
                .get("/teams/")
                .then()
                .statusCode(200);
    }

    @Test
    void getTeamByIdEndpoint() {
        given()
                .when()
                .pathParams("id", 20)
                .get("/teams/{id}")
                .then()
                .statusCode(200)
                .body("createdAt", notNullValue())
                .body("defaultLocation", equalTo("Lisbon"))
                .body("modifiedAt", notNullValue())
                .body("name", equalTo("AAAAAA"))
                .body("product", equalTo("WASASASASA"));

    }

    @Test
    @Transactional
    void addTeamEndpoint() {
        // Arrange
        TeamDTO teamDTO = new TeamDTO("Team Name", "Product Name", "Lisbon");
        // Act & Assert
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(teamDTO)
                .when().post("/teams")
                .then()
                .statusCode(200);
    }
}
