package com.example.exit_service.entity;

import java.time.LocalDateTime;

public class ExitRequest {

    private String ticketNumber;
    private String vehicleType;
    private LocalDateTime entryTime;

    // Getters and Setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ExitRequest(String ticketNumber, String vehicleType, LocalDateTime entryTime) {
        this.ticketNumber = ticketNumber;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
    }

    public ExitRequest() {

    }
}

