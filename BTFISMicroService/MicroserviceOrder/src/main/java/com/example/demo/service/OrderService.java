package com.example.demo.service;

import com.example.demo.model.response.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    public List<OrderResponseDTO> getOrders();
}
