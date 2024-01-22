package com.example.fis.model.response;

import com.example.fis.entity.*;
import com.example.fis.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private User customer;
    private Address address;
    private String codeOrder;
    private Pay pay;
    private Ship ship;
    private String note;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;
    private LocalDateTime dateShip;
    private LocalDateTime datePay;
    private Double orderValue;
    private StatusOrder statusOrder;
    private User employee;
    private List<OrderDetail> orderDetailList;
    private Double feeShip;
}
