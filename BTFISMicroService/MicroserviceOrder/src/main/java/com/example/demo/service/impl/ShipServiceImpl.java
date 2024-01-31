package com.example.demo.service.impl;

import com.example.demo.model.response.ShipDTO;
import com.example.demo.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.ship_service_url}")
    private String shipServiceUrl;

    @Override
    public ShipDTO getShipDto(Long id) {
        return restTemplate.getForObject(shipServiceUrl + id, ShipDTO.class);
    }
}
