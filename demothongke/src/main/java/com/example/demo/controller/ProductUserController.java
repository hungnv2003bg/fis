package com.example.demo.controller;

import com.example.demo.repo.ProductUserRepo;
import com.example.demo.service.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductUserController {
    @Autowired
    ProductUserRepo productUserRepo;

    @Autowired
    ProductUserService service;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(productUserRepo.findAll());
    }

    @GetMapping("/findallbyproduct")
    public ResponseEntity<?> getPrUser() {
        return ResponseEntity.ok(service.findAllByProduct());
    }

    @GetMapping("/findallbyuser")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(service.findAllByUser());
    }

}
