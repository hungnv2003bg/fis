package com.example.demo.service.impl;

import com.example.demo.model.response.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.user_service_url}")
    private String userServiceUrl;

    @Override
    public UserDTO getUserById(Long id) {
        return restTemplate.getForObject(userServiceUrl + id, UserDTO.class);
    }
}
