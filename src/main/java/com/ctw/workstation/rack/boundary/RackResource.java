package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.boundary.TeamService;
import com.ctw.workstation.team.entity.Team;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/racks")
public class RackResource {
    @Inject
    RackService rackService;
    @Inject
    TeamService teamService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRack(Rack rack) {
        Team team = teamService.getTeamById(rack.getTeamId());
        rack.setTeam(team);
        rackService.addRack(rack);
        return Response.status(Response.Status.CREATED).entity(rack).build();
    }

    @GET
    //@Operation(summary = "Get all racks", description = "Returns a list of all racks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRacks() {
        return Response.ok(rackService.getRacks()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRackById(@PathParam("id") Long id) {
        Rack rack = rackService.getRackById(id);
        if (rack != null) {
            return Response.ok(rack).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRackById(@PathParam("id") Long id, Rack rackToUpdate) {
        rackToUpdate.setId(id);
        rackService.updateRackById(rackToUpdate);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRackById(@PathParam("id") Long id) {
        Rack currentRackInDB = rackService.getRackById(id);
        if (currentRackInDB == null) return Response.status(Response.Status.NOT_FOUND).build();

        rackService.deleteRackById(id);
        return Response.ok().build();
    }

    @GET
    @Path("/status/{status}")
    public Response getRacksByStatus(@PathParam("status") String status) {
        if (status == null || status.isBlank()) return Response.status(Response.Status.NOT_FOUND).build();

        List<Rack> racksWitStatus = rackService.getAllRacksWithSpecificStatus(Status.valueOf(status));

        if (racksWitStatus.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(racksWitStatus).build();
    }
}
