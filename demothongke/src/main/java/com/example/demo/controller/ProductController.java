package com.example.demo.controller;

import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;



    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(productRepo.findAll());
    }

}
