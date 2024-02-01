package com.example.demo.service.impl;

import com.example.demo.model.response.CheckOut;
import com.example.demo.service.OrderCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderCustomerServiceImpl implements OrderCustomerService {

    @Override
    public CheckOut getDataPay(Long userId) {
        return null;
    }
}
