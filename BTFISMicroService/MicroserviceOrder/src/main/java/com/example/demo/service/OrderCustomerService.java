package com.example.demo.service;

import com.example.demo.model.response.CheckOut;

public interface OrderCustomerService {
    CheckOut getDataPay(Long userId);
}
