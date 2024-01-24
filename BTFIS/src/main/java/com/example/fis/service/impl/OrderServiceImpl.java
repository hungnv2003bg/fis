package com.example.fis.service.impl;

import com.example.fis.entity.Order;
import com.example.fis.entity.User;
import com.example.fis.enums.StatusOrder;
import com.example.fis.exception.BusinessException;
import com.example.fis.exception.ErrorCode;
import com.example.fis.mapper.*;
import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.model.response.*;
import com.example.fis.repository.OrderRepo;
import com.example.fis.repository.UserRepo;
import com.example.fis.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    private final InvoiceCancelMapper cancelMapper;

    private final InvoicePendingMapper pendingMapper;

    private final InvoicePendingShipMapper pendingShipMapper;

    private final InvoiceShippingMapper shippingMapper;

    private final InvoiceCompletedMapper completedMapper;

    private final OrderMapper orderMapper;

    private final UserRepo userRepo;

    @Override
    public List<InvoiceCancel> getInvoiceCancel() {
        List<Order> orderList = orderRepo.findAll();
        return orderList.stream()
                .filter(order -> order.getStatusOrder() == StatusOrder.CANCEL)
                .map(cancelMapper::toInvoiceCancel)
                .toList();
    }

    @Override
    public List<InvoicePending> getInvociePending() {
        List<Order> orderList = orderRepo.findAll();
        return orderList.stream()
                .filter(order -> order.getStatusOrder() == StatusOrder.CHOXACNHAN)
                .map(pendingMapper::toInvoicePending)
                .toList();
    }

    @Override
    public List<InvoicePendingShip> getInvociePendingShip() {
        List<Order> orderList = orderRepo.findAll();
        return orderList.stream()
                .filter(order -> order.getStatusOrder() == StatusOrder.CHOGIAOHANG)
                .map(pendingShipMapper::toInvoicePendingShip)
                .toList();
    }

    @Override
    public List<InvoiceShipping> getInvoiceShipping() {
        List<Order> orderList = orderRepo.findAll();
        return orderList.stream()
                .filter(order -> order.getStatusOrder() == StatusOrder.DANGGIAO)
                .map(shippingMapper::toInvoiceShipping)
                .toList();
    }

    @Override
    public List<InvoiceCompleted> getInvoiceCompleted() {
        List<Order> orderList = orderRepo.findAll();
        return orderList.stream()
                .filter(order -> order.getStatusOrder() == StatusOrder.DAGIAO)
                .map(completedMapper::toInvoiceCompleted)
                .toList();
    }

    @Override
    public List<OrderResponse> getOrders() {
        List<Order> orderList = orderRepo.findAll();
        return orderList.stream().map(orderMapper::toOrderResponse).toList();
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

    @Override
    public BigDecimal sumRevenue(LocalDateTime selectedDateStart, LocalDateTime selectedDateEnd) {
        return orderRepo.sumRevenue(selectedDateStart, selectedDateEnd);
    }
}
