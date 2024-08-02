package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.DatabaseTestResource;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.ctw.workstation.rack.boundary.RackResourceTest.prepareTestRack;
import static com.ctw.workstation.rack.boundary.RackResourceTest.prepareTestTeam;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@QuarkusTestResource(DatabaseTestResource.class)
public class RackResourceEndpointTest {
    private static final Jsonb JSONB = JsonbBuilder.create();
    @Inject
    RackResource rackResource;

    static Team team;

    @BeforeAll
    static void setUp() {
        prepareTestTeam();
    }

    @Test
    @Transactional
    void updateRackByIdEndPoint() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("serialNumber", "ANOTHERONE");
        requestBody.put("teamId", "20");
        requestBody.put("defaultLocation", "Porto");
        requestBody.put("status", "UNAVAILABLE");

        given()
                .pathParams("id", 51)
                .contentType(ContentType.JSON)
                .body(requestBody).
        when()
                .put("/racks/{id}")
                .then()
                .statusCode(200)
                .body("defaultLocation", equalTo("Porto"))
                .body("serialNumber", equalTo("ANOTHERONE"))
                .body("status", equalTo("UNAVAILABLE"));

    }

    @Test
    void getRackByIdEndpoint() {
        given().pathParams("id", 51L)
                .when()
                .get("/racks/{id}")
                .then()
                .statusCode(200)
                .body("serialNumber", equalTo("111"));
    }

    static void prepareTestTeam() {
        team = new Team();
        team.setDefaultLocation("Lisbon");
        team.setName("Name");
        team.setProduct("Product");
        team.setId(1L);
    }
}
