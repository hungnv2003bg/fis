package com.example.demo.service;

import com.example.demo.entity.Ship;

import java.util.Optional;

public interface ShipService {
    Optional<Ship> getShip(Long id);
}
