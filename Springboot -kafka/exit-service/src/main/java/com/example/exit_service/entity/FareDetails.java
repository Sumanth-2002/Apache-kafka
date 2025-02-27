package com.example.exit_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FareDetails {

    @Id

    private Long id;

    private String ticketNumber;
    private double totalAmount;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public FareDetails(Long id, String ticketNumber, double totalAmount) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.totalAmount = totalAmount;
    }

    public FareDetails() {

    }
}

