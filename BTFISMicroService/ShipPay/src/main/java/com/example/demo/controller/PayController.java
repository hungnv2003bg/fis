package com.example.demo.controller;

import com.example.demo.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/pay")
public class PayController {
    private final PayService payService;

    @GetMapping({"{id}"})
    public ResponseEntity<?> getPay(@PathVariable Long id) {
        return ResponseEntity.ok(payService.getPay(id));
    }
}
