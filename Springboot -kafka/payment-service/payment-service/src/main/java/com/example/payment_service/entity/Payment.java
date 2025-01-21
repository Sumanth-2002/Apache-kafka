package com.example.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id

    private Long id;

    private String receiptNumber;
    private double amountPaid;
    private String paymentMode;
    private LocalDateTime paymentTime;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Payment(Long id, String receiptNumber, double amountPaid, String paymentMode, LocalDateTime paymentTime) {
        this.id = id;
        this.receiptNumber = receiptNumber;
        this.amountPaid = amountPaid;
        this.paymentMode = paymentMode;
        this.paymentTime = paymentTime;
    }

    public Payment() {

    }
}
