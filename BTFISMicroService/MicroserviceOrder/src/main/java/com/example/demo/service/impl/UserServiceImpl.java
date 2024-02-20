package com.example.demo.service.impl;

import com.example.demo.base.BaseResponseInternal;
import com.example.demo.base.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.user_service_url}")
    private String userServiceUrl;


    @Override
    public UserResponse getUserById(Long customerId) {
        ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(
                userServiceUrl + customerId,
                HttpMethod.GET,
                null,
                UserResponse.class
        );
        return responseEntity.getBody();
    }


}
