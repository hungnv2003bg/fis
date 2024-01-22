package com.example.fis.mapper;

import com.example.fis.entity.Order;
import com.example.fis.model.response.InvoicePending;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoicePendingMapper {

    public InvoicePending toInvoicePending(Order order) {
        InvoicePending invoicePending = new InvoicePending();
        invoicePending.setKey(order.getId());
        invoicePending.setCodeOrder(order.getCodeOrder());
        invoicePending.setNameCustomer(order.getCustomer().getName());
        invoicePending.setPhone(order.getCustomer().getPhone());
        invoicePending.setOrderDetailList(order.getOrderDetailList());
        invoicePending.setCreateDate(order.getCreateDate());
        invoicePending.setStatus(order.getStatusOrder());
        return invoicePending;
    }
}
