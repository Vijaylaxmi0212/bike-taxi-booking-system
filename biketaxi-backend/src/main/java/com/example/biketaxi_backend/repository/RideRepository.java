package com.example.biketaxi_backend.repository;

import com.example.biketaxi_backend.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
