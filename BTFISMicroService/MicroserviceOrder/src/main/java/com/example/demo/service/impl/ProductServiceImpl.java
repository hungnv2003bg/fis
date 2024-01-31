package com.example.demo.service.impl;

import com.example.demo.model.response.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.product_service_url}")
    private String productServiceUrl;

    @Override
    public ProductDTO getProductById(Long id) {
        return restTemplate.getForObject(productServiceUrl + id, ProductDTO.class);
    }
}
