/*
package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class BookingService {
    private Map<String, Booking> bookingDatabase = new HashMap<>();

    public Booking addBooking (Booking booking){
        String id = UUID.randomUUID().toString();
        booking.setId(id);

        bookingDatabase.put(id, booking);
        return booking;
    }
}
*/