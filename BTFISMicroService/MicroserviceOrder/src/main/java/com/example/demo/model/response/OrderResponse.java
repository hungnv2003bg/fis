package com.example.demo.model.response;

import com.example.demo.entity.OrderDetail;
import com.example.demo.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private Long customerId;
    private Long addressId;
    private String codeOrder;
    private Long payId;
    private Long shipId;
    private String note;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;
    private LocalDateTime dateShip;
    private LocalDateTime datePay;
    private Double orderValue;
    private StatusOrder statusOrder;
    private Long cartId;
    private List<OrderDetail> orderDetailList;
    private Double feeShip;
}
