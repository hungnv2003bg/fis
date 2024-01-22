package com.example.fis.service;

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

    InvoicePendingShip toInvoicePendingShip(Long id, OrderUpdateRequest updateRequest);

    InvoiceShipping toInvoiceShipping(Long id, OrderUpdateRequest updateRequest);

    InvoiceCompleted toInvoiceCompleted(Long id, OrderUpdateRequest updateRequest);
}
