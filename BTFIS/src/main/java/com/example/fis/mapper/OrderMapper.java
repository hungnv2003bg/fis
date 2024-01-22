package com.example.fis.mapper;

import com.example.fis.entity.Order;
import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.model.request.order.OrderUpdateRequest;
import com.example.fis.model.response.OrderResponse;
import com.example.fis.repository.AddressRepo;
import com.example.fis.repository.PayRepo;
import com.example.fis.repository.ShipRepo;
import com.example.fis.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class OrderMapper {
    private final UserRepo userRepo;

    private final AddressRepo addressRepo;

    private final PayRepo payRepo;

    private final ShipRepo shipRepo;

    public Order toOrder(OrderSaveRequest saveRequest) {
        Order order = new Order();
        order.setId(saveRequest.getId());
        order.setCodeOrder(saveRequest.getCodeOrder());
        order.setCustomer(userRepo.findById(saveRequest.getCustomerId()).get());
        order.setAddress(addressRepo.findById(saveRequest.getAddressId()).get());
        order.setPay(payRepo.findById(saveRequest.getPayId()).get());
        order.setShip(shipRepo.findById(saveRequest.getShipId()).get());
        order.setNote(saveRequest.getNote());
        order.setOrderDetailList(saveRequest.getOrderDetailList());
        order.setCreateDate(LocalDateTime.now());
        order.setStatusOrder(saveRequest.getStatusOrder());
        order.setFeeShip(order.getFeeShip());
        return order;
    }

    public Order toOrder(OrderUpdateRequest updateRequest) {
        Order order = new Order();
        order.setCustomer(userRepo.findById(updateRequest.getCustomerId()).get());
        order.setAddress(addressRepo.findById(updateRequest.getAddressId()).get());
        order.setOrderDetailList(updateRequest.getOrderDetailList());
        order.setUpdatedDate(LocalDateTime.now());
        order.setStatusOrder(updateRequest.getStatusOrder());
        return order;
    }

    public OrderResponse toOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setCustomer(order.getCustomer());
        orderResponse.setAddress(order.getAddress());
        orderResponse.setCodeOrder(order.getCodeOrder());
        orderResponse.setPay(order.getPay());
        orderResponse.setShip(order.getShip());
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
