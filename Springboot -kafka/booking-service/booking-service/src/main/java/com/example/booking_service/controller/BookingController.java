package com.example.booking_service.controller;

import com.example.booking_service.entity.Booking;
import com.example.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookParking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.bookParking(booking);
        return ResponseEntity.ok("Booking Successful. Ticket Number: " + savedBooking.getTicketNumber());
    }
}
