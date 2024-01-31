package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.response.*;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.*;
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
    private UserService userService;

    @Override
    public List<OrderResponseDTO> getOrders() {
        List<OrderResponseDTO> orderResponseDTOs = new ArrayList<>();

        List<Order> orders = orderRepo.findAll();

        for (Order order : orders) {
            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

            PayDTO payDTO = payService.getPayDto(order.getPayId());
            ShipDTO shipDTO = shipService.getShipDto(order.getShipId());
            UserDTO userDTO = userService.getUserById(order.getCustomerId());

            OrderResponse orderResponse = orderMapper.toOrderResponse(order);
            orderResponseDTO.setOrderResponse(orderResponse);
            orderResponseDTO.setPayName(payDTO.getNamePay());
            orderResponseDTO.setCustomerName(userDTO.getName());
            orderResponseDTO.setShipName(shipDTO.getNameShip());

            orderResponseDTOs.add(orderResponseDTO);
        }

        return orderResponseDTOs;
    }

}
