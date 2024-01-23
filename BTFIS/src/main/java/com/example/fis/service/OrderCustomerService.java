package com.example.fis.service;

import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.model.response.CheckOut;
import com.example.fis.model.response.OrderResponse;

public interface OrderCustomerService {
    OrderResponse addOrder(OrderSaveRequest orderSaveRequest);

    OrderResponse addOrderVnPay(OrderSaveRequest orderSaveRequest);

    public void checkPayVNPay(Long id, Long statusOrder);

    public CheckOut getDataPay(Long userId);
}