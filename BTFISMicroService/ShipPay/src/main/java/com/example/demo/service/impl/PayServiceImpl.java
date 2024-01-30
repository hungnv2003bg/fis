package com.example.demo.service.impl;

import com.example.demo.entity.Pay;
import com.example.demo.repo.PayRepo;
import com.example.demo.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PayServiceImpl implements PayService {
    private final PayRepo payRepo;

    @Override
    public Optional<Pay> getPay(Long id) {
        return payRepo.findById(id);
    }
}
