package com.example.biketaxi_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.biketaxi_backend.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}