package com.example.demo.controller;

import com.example.demo.service.ShipService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/ship")
public class ShipController {
    private final ShipService shipService;

    @GetMapping({"{id}"})
    public ResponseEntity<?> getShip(@PathVariable Long id) {
        return ResponseEntity.ok(shipService.getShip(id));
    }
}
