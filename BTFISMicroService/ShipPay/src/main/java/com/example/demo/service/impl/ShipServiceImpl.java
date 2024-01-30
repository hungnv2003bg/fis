package com.example.demo.service.impl;

import com.example.demo.entity.Ship;
import com.example.demo.repo.ShipRepo;
import com.example.demo.service.ShipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShipServiceImpl implements ShipService {
    private final ShipRepo shipRepo;

    @Override
    public Optional<Ship> getShip(Long id) {
        return shipRepo.findById(id);
    }
}
