package com.example.demo.service;

import com.example.demo.model.response.ProductDTO;

public interface ProductService {
    ProductDTO getProductById(Long id);
}
