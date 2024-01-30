package com.example.demo.model.request.order;

import com.example.demo.entity.OrderDetail;
import com.example.demo.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderSaveRequest {
    private Long id;
    private Long customerId;
    private Long addressId;
    private String codeOrder;
    private Long payId;
    private Long shipId;
    private String note;
    private LocalDateTime createDate;
    private LocalDateTime dateShip;
    private LocalDateTime datePay;
    private Double orderValue;
    private StatusOrder statusOrder;
    private List<OrderDetail> orderDetailList;
    private Double feeShip;
}
