package com.example.payment_service.service;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public Payment processPayment(Payment payment) {
        payment.setPaymentTime(LocalDateTime.now());
        payment.setReceiptNumber(UUID.randomUUID().toString());
        Payment savedPayment = paymentRepository.save(payment);
        kafkaTemplate.send("payment_processing", savedPayment);
        return savedPayment;
    }

    @KafkaListener(topics = "payment_processing", groupId = "parking_group")
    public void listenPaymentMessages(Payment payment) {
        System.out.println("Received payment message: " + payment);
    }
}
