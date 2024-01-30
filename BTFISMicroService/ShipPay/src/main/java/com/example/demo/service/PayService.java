package com.example.demo.service;

import com.example.demo.entity.Pay;

import java.util.Optional;

public interface PayService {
    Optional<Pay> getPay(Long id);
}
