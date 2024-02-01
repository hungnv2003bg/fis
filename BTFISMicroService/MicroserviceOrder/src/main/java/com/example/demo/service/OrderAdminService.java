package com.example.demo.service;

import com.example.demo.model.response.OrderResponse;
import com.example.demo.model.response.OrderResponseDTO;

import java.util.List;

public interface OrderAdminService {
    List<OrderResponseDTO> getOrders();

    OrderResponse updateOrderStatus(Long id, String newStatus);
}
