package com.ctw.workstation.booking.entity;

import com.ctw.workstation.teamMember.entity.TeamMember;
import jakarta.persistence.*;
import com.ctw.workstation.rack.entity.Rack;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "SEQ_BOOKING_ID")
    private long id;
    @Column(name = "RACK_ID")
    private long rackId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    private Rack rack;
    @Column(name = "REQUESTER_ID")
    private long requesterId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUESTER_ID", updatable = false, insertable = false, nullable = false)
    private TeamMember requester;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BOOK_FROM")
    private LocalDateTime bookFrom;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BOOK_TO")
    private LocalDateTime bookTo;

    public Booking() {
    }

    public Booking(long rackId, long requesterId, LocalDateTime bookFrom, LocalDateTime bookTo) {
        this.rackId = rackId;
        this.requesterId = requesterId;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRackId() {
        return rackId;
    }

    public void setRackId(long rackId) {
        this.rackId = rackId;
    }

    public long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(long requesterId) {
        this.requesterId = requesterId;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public TeamMember getRequester() {
        return requester;
    }

    public void setRequester(TeamMember requester) {
        this.requester = requester;
    }
}
