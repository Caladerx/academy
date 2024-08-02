package com.ctw.workstation.rack.entity;

public enum Status {
    AVAILABLE,
    BOOKED,
    UNAVAILABLE;

    public Status convertStringToStatus(String stringStatus){
        return switch (stringStatus) {
            case "AVAILABLE" -> Status.AVAILABLE;
            case "BOOKED" -> Status.BOOKED;
            case "UNAVAILABLE" -> Status.UNAVAILABLE;
            default -> null;
        };
    }
}
