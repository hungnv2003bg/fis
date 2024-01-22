package com.example.fis.mapper;

import com.example.fis.entity.Order;
import com.example.fis.model.response.InvoiceCompleted;
import org.springframework.stereotype.Component;

@Component
public class InvoiceCompletedMapper {
    public InvoiceCompleted toInvoiceCompleted(Order order) {
        InvoiceCompleted invoiceCompleted = new InvoiceCompleted();
        invoiceCompleted.setKey(order.getId());
        invoiceCompleted.setCodeOrder(order.getCodeOrder());
        invoiceCompleted.setNameCustomer(order.getCustomer().getName());
        invoiceCompleted.setPhone(order.getCustomer().getPhone());
        invoiceCompleted.setOrderDetailList(order.getOrderDetailList());
        invoiceCompleted.setCreateDate(order.getCreateDate());
        invoiceCompleted.setStatus(order.getStatusOrder());
        invoiceCompleted.setDatePay(order.getDatePay());
        return invoiceCompleted;
    }
}
