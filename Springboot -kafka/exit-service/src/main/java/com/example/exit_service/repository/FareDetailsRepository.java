package com.example.exit_service.repository;

import com.example.exit_service.entity.FareDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareDetailsRepository extends JpaRepository<FareDetails, Long> {
}
