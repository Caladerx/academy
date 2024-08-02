package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {
    public Booking findById(UUID id) {
        return findById(id);
    }

    public List<Booking> findAllBookings() {
        return listAll();
    }
}
