package com.example.demo.service.impl;

import com.example.demo.model.response.PayDTO;
import com.example.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.pay_service_url}")
    private String payServiceUrl;

    @Override
    public PayDTO getPayDto(Long id) {
        return restTemplate.getForObject(payServiceUrl + id, PayDTO.class);
    }
}
