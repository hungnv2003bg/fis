package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.response.*;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import com.example.demo.service.PayService;
import com.example.demo.service.ShipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceimpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CartService cartService;
    private final ShipService shipService;
    private final PayService payService;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponseDTO> getOrders() {
        List<OrderResponseDTO> orderResponseDTOs = new ArrayList<>();

        List<Order> orders = orderRepo.findAll();

        for (Order order : orders) {
            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

            CartResponse cartResponse = cartService.getCartResponse(order.getCartId());
            PayDTO payDTO = payService.getPayDto(order.getPayId());
            ShipDTO shipDTO = shipService.getShipDto(order.getShipId());

            OrderResponse orderResponse = orderMapper.toOrderResponse(order);
            orderResponseDTO.setCustomerName(cartResponse.getNameCustomer());
            orderResponse.setShipId(shipDTO.getId());

            orderResponseDTOs.add(orderResponseDTO);
        }

        return orderResponseDTOs;
    }

}
