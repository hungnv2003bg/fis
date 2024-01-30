package com.example.demo.service.impl;

import com.example.demo.model.response.OrderResponseDTO;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceimpl implements OrderService {
    private final OrderRepo orderRepo;


    @Override
    public List<OrderResponseDTO> getOrders() {
        return null;
    }
}
