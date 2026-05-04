package com.example.biketaxi_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biketaxi_backend.entity.*;
import com.example.biketaxi_backend.repository.*;

import java.time.LocalDateTime;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private DriverRepository driverRepository;

    public Ride requestRide(Ride ride) {
        ride.setStatus(RideStatus.PENDING);
        ride.setCreatedAt(LocalDateTime.now());
        return rideRepository.save(ride);
    }

    public Ride acceptRide(Long rideId, Long driverId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        if (ride.getStatus() != RideStatus.PENDING) {
            throw new RuntimeException("Ride cannot be accepted");
        }

        ride.setDriver(driver);
        ride.setStatus(RideStatus.ACCEPTED);

        driver.setAvailable(false);

        return rideRepository.save(ride);
    }

    public Ride updateStatus(Long rideId, RideStatus status) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        ride.setStatus(status);

        return rideRepository.save(ride);
    }
    public java.util.List<Ride> getAllRides() {
        return rideRepository.findAll();
    }
}