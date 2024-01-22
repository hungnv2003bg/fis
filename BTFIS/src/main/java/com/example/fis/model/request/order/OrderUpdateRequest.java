package com.example.fis.model.request.order;

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
public class OrderUpdateRequest {
    private Long customerId;
    private Long addressId;
    private String codeOrder;
    private Long payId;
    private Ship shipId;
    private String noteId;
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
