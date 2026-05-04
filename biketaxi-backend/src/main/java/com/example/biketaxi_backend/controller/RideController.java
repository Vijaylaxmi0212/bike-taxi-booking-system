package com.example.biketaxi_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.biketaxi_backend.entity.*;
import com.example.biketaxi_backend.service.RideService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private RideService rideService;


    @GetMapping
    public java.util.List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @PostMapping("/request")
    public Ride requestRide(@RequestBody Ride ride) {
        return rideService.requestRide(ride);
    }

    @PostMapping("/{rideId}/accept/{driverId}")
    public Ride acceptRide(@PathVariable Long rideId,
                           @PathVariable Long driverId) {
        return rideService.acceptRide(rideId, driverId);
    }

    @GetMapping("/test")
    public String test() {
        return "Ride Working";
    }

    @PutMapping("/{rideId}/status")
    public Ride updateStatus(@PathVariable Long rideId,
                             @RequestParam RideStatus status) {
        return rideService.updateStatus(rideId, status);
    }
}