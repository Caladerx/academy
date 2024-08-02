package com.ctw.workstation.booking.entity;

import java.time.LocalDateTime;

public class BookingDTO {
    private String rackId;
    private String requesterId;
    private LocalDateTime bookFrom;
    private LocalDateTime bookTo;

    public BookingDTO() {
    }

    public BookingDTO(String rackId, String requesterId, LocalDateTime bookFrom, LocalDateTime bookTo) {
        this.rackId = rackId;
        this.requesterId = requesterId;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }

    public String getRackId() {
        return rackId;
    }

    public void setRackId(String rackId) {
        this.rackId = rackId;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
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
}
