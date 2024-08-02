
package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jboss.logging.MDC;

import java.util.UUID;


@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    @Inject
    TeamService teamService;
    private static Logger logger = Logger.getLogger(TeamResource.class.getName());

    @GET
    public Response getTeams() {
        logger.info("Getting all Teams");
        return Response.ok(teamService.getAllTeams()).build();
    }

    @POST
    public Response addTeam(TeamDTO teamDTO) {
        // logger.infof("Adding team to DB: Name: %s based in %s",teamDTO.name(), teamDTO.getDefaultLocation());
        logger.infov("Adding team to DB - Name: {0} based in {1}",teamDTO.name(), teamDTO.getDefaultLocation());
       /* logger.info("Adding team to DB: Name: "
                + teamDTO.name() + " based in "
                + teamDTO.getDefaultLocation()); */
    UUID uuidToAddToLogs = UUID.randomUUID();
        MDC.put("uuiddAdded", uuidToAddToLogs.toString());
        teamService.addTeam(teamDTO);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamById(@PathParam("id") long id) {
        logger.info("Getting Team by ID: " + id);
        Team team = teamService.getTeamById(id);
        if(team!=null) return Response.ok(teamService.getTeamById(id)).build();
        return Response.status(404).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeam(@PathParam("id") long id, TeamDTO teamDTO) {
        try {
            teamService.updateTeam(id, teamDTO);
            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
