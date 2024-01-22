package com.example.fis.mapper;

import com.example.fis.entity.Order;
import com.example.fis.model.response.InvoiceShipping;
import org.springframework.stereotype.Component;

@Component
public class InvoiceShippingMapper {
    public InvoiceShipping toInvoiceShipping(Order order) {
        InvoiceShipping invoiceShipping = new InvoiceShipping();
        invoiceShipping.setKey(order.getId());
        invoiceShipping.setCodeOrder(order.getCodeOrder());
        invoiceShipping.setNameCustomer(order.getCustomer().getName());
        invoiceShipping.setPhone(order.getCustomer().getPhone());
        invoiceShipping.setOrderDetailList(order.getOrderDetailList());
        invoiceShipping.setCreateDate(order.getCreateDate());
        invoiceShipping.setStatus(order.getStatusOrder());
        invoiceShipping.setDateShip(order.getDateShip());
        return invoiceShipping;
    }
}
