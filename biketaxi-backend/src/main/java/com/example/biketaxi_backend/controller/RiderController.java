package com.example.biketaxi_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.biketaxi_backend.entity.Rider;
import com.example.biketaxi_backend.repository.RiderRepository;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/riders")
public class RiderController {

    @Autowired
    private RiderRepository riderRepository;

    @PostMapping
    public Rider createRider(@RequestBody Rider rider) {
        return riderRepository.save(rider);
    }

    @GetMapping("/test")
    public String test() {
        return "Working";
    }

    @GetMapping
    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }
}