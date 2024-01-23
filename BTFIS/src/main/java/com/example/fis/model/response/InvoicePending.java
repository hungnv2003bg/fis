package com.example.fis.model.response;

import com.example.fis.entity.OrderDetail;
import com.example.fis.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoicePending {
    private Long key;
    private String codeOrder;
    private String nameCustomer;
    private String phone;
    private List<OrderDetail> orderDetailList;
    private LocalDateTime createDate;
    private StatusOrder status;
}
