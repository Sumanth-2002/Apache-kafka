package com.example.exit_service.service;

import com.example.exit_service.entity.ExitRequest;
import com.example.exit_service.entity.FareDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ExitService {

    @Autowired
    private KafkaTemplate<String, FareDetails> kafkaTemplate;

    public FareDetails calculateFare(ExitRequest exitRequest) {
        long duration = Duration.between(exitRequest.getEntryTime(), LocalDateTime.now()).toMinutes();
        double rate = getRateByVehicleType(exitRequest.getVehicleType());
        double totalAmount = (duration / 60.0) * rate;

        FareDetails fareDetails = new FareDetails();
        fareDetails.setTicketNumber(exitRequest.getTicketNumber());
        fareDetails.setTotalAmount(totalAmount);
        kafkaTemplate.send("fare_calculation", fareDetails);
        return fareDetails;
    }

    private double getRateByVehicleType(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "bike": return 10;
            case "car": return 20;
            case "auto": return 15;
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }

    @KafkaListener(topics = "fare_calculation", groupId = "parking_group")
    public void listenFareMessages(FareDetails fareDetails) {
        System.out.println("Received fare message: " + fareDetails);
    }
}

