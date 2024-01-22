package com.example.fis.mapper;

import com.example.fis.entity.Order;
import com.example.fis.model.response.InvoiceCancel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceCancelMapper {
    public InvoiceCancel toInvoiceCancel(Order order){
        InvoiceCancel invoiceCancel = new InvoiceCancel();
        invoiceCancel.setKey(order.getId());
        invoiceCancel.setCodeOrder(order.getCodeOrder());
        invoiceCancel.setNameCustomer(order.getCustomer().getName());
        invoiceCancel.setPhone(order.getCustomer().getPhone());
        invoiceCancel.setOrderDetailList(order.getOrderDetailList());
        invoiceCancel.setCreateDate(order.getCreateDate());
        invoiceCancel.setStatus(order.getStatusOrder());
        return invoiceCancel;
    }
}
