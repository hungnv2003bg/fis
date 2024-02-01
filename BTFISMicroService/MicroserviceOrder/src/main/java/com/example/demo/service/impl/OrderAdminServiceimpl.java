package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.enums.StatusOrder;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.response.*;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderAdminServiceimpl implements OrderAdminService {
    private final OrderRepo orderRepo;
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

    @Override
    public OrderResponse updateOrderStatus(Long id, String newStatus) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUD);
        }
        Order order = orderOptional.get();
        StatusOrder targetStatus = StatusOrder.valueOf(newStatus);

        check(order, targetStatus);
        order.setStatusOrder(targetStatus);
        orderRepo.save(order);

        return orderMapper.toOrderResponse(order);
    }

    private void check(Order order, StatusOrder targetStatus) {
        StatusOrder currentStatus = order.getStatusOrder();

        if (currentStatus == StatusOrder.DANGGIAO && targetStatus == StatusOrder.DAGIAO) {
            order.setDateShip(LocalDateTime.now());
        }

        if (!isValidStatus(targetStatus)) {
            throw new BusinessException(ErrorCode.INVALID_STATUS);
        }
    }

    private boolean isValidStatus(StatusOrder status) {
        return status == StatusOrder.CHOGIAOHANG ||
                status == StatusOrder.DANGGIAO ||
                status == StatusOrder.DAGIAO ||
                status == StatusOrder.CHOXACNHAN;
    }

}
