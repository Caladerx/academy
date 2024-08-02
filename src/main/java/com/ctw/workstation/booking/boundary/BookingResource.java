/*
package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/bookings")
public class BookingResource {
    @Inject
    BookingService bookingService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBooking(BookingDTO booking){
        Booking newBooking = bookingService.addBooking(new Booking(booking.getRackId(),
                booking.getRequesterId(), booking.getBookFrom(), booking.getBookTo()));

        return Response.status(Response.Status.CREATED).entity(newBooking).build();
    }
}
*/