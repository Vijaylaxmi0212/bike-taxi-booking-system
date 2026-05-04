package com.example.biketaxi_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
}