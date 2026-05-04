package com.example.biketaxi_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickupLocation;
    private String dropLocation;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    @ManyToOne
    private Rider rider;

    @ManyToOne
    private Driver driver;

    private LocalDateTime createdAt;
}