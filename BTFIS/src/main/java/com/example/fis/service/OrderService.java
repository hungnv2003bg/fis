package com.example.fis.service;

import com.example.fis.mapper.OrderMapper;
import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.model.request.order.OrderUpdateRequest;
import com.example.fis.model.response.*;

import java.util.List;

public interface OrderService {
    List<InvoiceCancel> getInvoiceCancel();

    List<InvoicePending> getInvociePending();

    List<InvoicePendingShip> getInvociePendingShip();

    List<InvoiceShipping> getInvoiceShipping();

    List<InvoiceCompleted> getInvoiceCompleted();

    List<OrderResponse> getOrders();

//    InvoicePendingShip toInvoicePendingShip(Long id, OrderUpdateRequest updateRequest);

//    OrderResponse toInvoiceShipping(Long id, OrderUpdateRequest updateRequest);
//
//    OrderResponse toInvoiceCompleted(Long id, OrderUpdateRequest updateRequest);

//    OrderResponse updateStatus(Long id, OrderUpdateRequest updateRequest);

    OrderResponse updateOrderStatus(Long id, String newStatus);
}
