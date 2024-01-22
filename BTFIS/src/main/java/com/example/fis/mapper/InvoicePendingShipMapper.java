package com.example.fis.mapper;

import com.example.fis.entity.Order;
import com.example.fis.model.response.InvoicePendingShip;
import org.springframework.stereotype.Component;

@Component
public class InvoicePendingShipMapper {
    public InvoicePendingShip toInvoicePendingShip(Order order) {
        InvoicePendingShip invoicePendingShip = new InvoicePendingShip();
        invoicePendingShip.setKey(order.getId());
        invoicePendingShip.setCodeOrder(order.getCodeOrder());
        invoicePendingShip.setNameCustomer(order.getCustomer().getName());
        invoicePendingShip.setPhone(order.getCustomer().getPhone());
        invoicePendingShip.setOrderDetailList(order.getOrderDetailList());
        invoicePendingShip.setCreateDate(order.getCreateDate());
        invoicePendingShip.setStatus(order.getStatusOrder());
        return invoicePendingShip;
    }
}
