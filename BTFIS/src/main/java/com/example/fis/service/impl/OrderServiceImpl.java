package com.example.fis.service.impl;

import com.example.fis.entity.Order;
import com.example.fis.enums.StatusOrder;
import com.example.fis.exception.BusinessException;
import com.example.fis.exception.ErrorCode;
import com.example.fis.mapper.*;
import com.example.fis.model.request.order.OrderUpdateRequest;
import com.example.fis.model.response.*;
import com.example.fis.repository.OrderRepo;
import com.example.fis.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public InvoicePendingShip toInvoicePendingShip(Long id, OrderUpdateRequest updateRequest) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUD);
        }
        Order order = orderOptional.get();
        order.setStatusOrder(updateRequest.getStatusOrder());
        orderRepo.save(order);
        return pendingShipMapper.toInvoicePendingShip(order);
    }

//    @Override
//    public OrderResponse toInvoiceShipping(Long id, OrderUpdateRequest updateRequest) {
//        Optional<Order> orderOptional = orderRepo.findById(id);
//        if (orderOptional.isEmpty()) {
//            throw new BusinessException(ErrorCode.ORDER_NOT_FOUD);
//        }
//        Order order = orderOptional.get();
//        order.setStatusOrder(updateRequest.getStatusOrder());
//        orderRepo.save(order);
//        return orderMapper.toOrderResponse(order);
//    }
//
//    @Override
//    public OrderResponse toInvoiceCompleted(Long id, OrderUpdateRequest updateRequest) {
//        Optional<Order> orderOptional = orderRepo.findById(id);
//        if (orderOptional.isEmpty()) {
//            throw new BusinessException(ErrorCode.ORDER_NOT_FOUD);
//        }
//        Order order = orderOptional.get();
//        order.setStatusOrder(updateRequest.getStatusOrder());
//        orderRepo.save(order);
//        return orderMapper.toOrderResponse(order);
//    }

    @Override
    public OrderResponse updateStatus(Long id, OrderUpdateRequest updateRequest) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUD);
        }
        Order order = orderOptional.get();


        StatusOrder newStatus = updateRequest.getStatusOrder();

        StatusOrder currentStatus = order.getStatusOrder();

        if (!check(currentStatus, newStatus)) {
            throw new BusinessException(ErrorCode.INVALID_STATUS);
        }
        order.setStatusOrder(newStatus);
        orderRepo.save(order);

        return orderMapper.toOrderResponse(order);
    }

    private boolean check(StatusOrder currentStatus, StatusOrder newStatus) {
        switch (currentStatus) {
            case CHOXACNHAN:
                return newStatus == StatusOrder.CHOGIAOHANG;
            case CHOGIAOHANG:
                return newStatus == StatusOrder.DANGGIAO;
            case DANGGIAO:
                return newStatus == StatusOrder.DAGIAO;
            default:
                return false;
        }
    }


}
