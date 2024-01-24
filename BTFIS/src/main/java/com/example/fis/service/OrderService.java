package com.example.fis.service;

import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.model.response.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<InvoiceCancel> getInvoiceCancel();

    List<InvoicePending> getInvociePending();

    List<InvoicePendingShip> getInvociePendingShip();

    List<InvoiceShipping> getInvoiceShipping();

    List<InvoiceCompleted> getInvoiceCompleted();

    List<OrderResponse> getOrders();

    OrderResponse updateOrderStatus(Long id, String newStatus);

    BigDecimal sumRevenue(LocalDateTime selectedDateStart, LocalDateTime selectedDateEnd);

}
