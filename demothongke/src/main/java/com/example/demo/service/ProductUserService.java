package com.example.demo.service;

import com.example.demo.dto.ProductCoutDTO;
import com.example.demo.dto.UserCountDTO;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.ProductUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUserService {
    @Autowired
    ProductUserRepo productUserRepo;

    public List<ProductCoutDTO> findAllByProduct(){
        return productUserRepo.findAllByProduct();
    }

    public List<UserCountDTO> findAllByUser(){
        return productUserRepo.findAllByUser();
    }
}
