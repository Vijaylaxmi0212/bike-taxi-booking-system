package com.example.biketaxi_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.biketaxi_backend.entity.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}
