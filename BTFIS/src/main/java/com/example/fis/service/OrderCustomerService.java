package com.example.fis.service;

import com.example.fis.model.response.OrderResponse;
import com.example.fis.model.request.order.OrderSaveRequest;

public interface OrderCustomerService {
    OrderResponse addOrder(OrderSaveRequest orderSaveRequest);
}
