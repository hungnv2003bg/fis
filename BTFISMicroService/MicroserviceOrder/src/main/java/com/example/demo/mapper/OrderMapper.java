package com.example.demo.mapper;


import com.example.demo.entity.Order;
import com.example.demo.model.request.order.OrderSaveRequest;
import com.example.demo.model.response.OrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class OrderMapper {

    public Order toOrder(OrderSaveRequest saveRequest) {
        Order order = new Order();
        order.setId(saveRequest.getId());
        order.setCodeOrder(saveRequest.getCodeOrder());
        order.setCustomer(saveRequest.getCustomerId());
        order.setAddress(saveRequest.getAddressId());
        order.setPayId(saveRequest.getPayId());
        order.setShipId(saveRequest.getShipId());
        order.setNote(saveRequest.getNote());
        order.setOrderDetailList(saveRequest.getOrderDetailList());
        order.setCreateDate(LocalDateTime.now());
        order.setStatusOrder(saveRequest.getStatusOrder());
        order.setFeeShip(order.getFeeShip());
        return order;
    }

    public OrderResponse toOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setCustomerId(order.getCustomer());
        orderResponse.setAddressId(order.getAddress());
        orderResponse.setCodeOrder(order.getCodeOrder());
        orderResponse.setPayId(order.getPayId());
        orderResponse.setShipId(order.getShipId());
        orderResponse.setNote(order.getNote());
        orderResponse.setCreateDate(order.getCreateDate());
        orderResponse.setUpdatedDate(order.getUpdatedDate());
        orderResponse.setDateShip(order.getDateShip());
        orderResponse.setDatePay(order.getDatePay());
        orderResponse.setOrderValue(order.getOrderValue());
        orderResponse.setStatusOrder(order.getStatusOrder());
        orderResponse.setOrderDetailList(order.getOrderDetailList());
        orderResponse.setFeeShip(order.getFeeShip());
        return orderResponse;
    }
}
