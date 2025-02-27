package com.example.exit_service.controller;

import com.example.exit_service.entity.ExitRequest;
import com.example.exit_service.entity.FareDetails;
import com.example.exit_service.service.ExitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exits")
public class ExitController {

    @Autowired
    private ExitService exitService;

    @PostMapping("/calculate")
    public ResponseEntity<FareDetails> calculateFare(@RequestBody ExitRequest exitRequest) {
        FareDetails fareDetails = exitService.calculateFare(exitRequest);
        return ResponseEntity.ok(fareDetails);
    }
}
