package com.example.booking_service.service;

import com.example.booking_service.entity.Booking;
import com.example.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private KafkaTemplate<String, Booking> kafkaTemplate;

    public Booking bookParking(Booking booking) {
        booking.setTicketNumber(UUID.randomUUID().toString());
        booking.setBookingTime(LocalDateTime.now());
        Booking savedBooking = bookingRepository.save(booking);
        kafkaTemplate.send("parking_booking", savedBooking);
        return savedBooking;
    }

    @KafkaListener(topics = "parking_booking", groupId = "parking_group")
    public void listenBookingMessages(Booking booking) {
        System.out.println("Received booking message: " + booking);
    }
}
