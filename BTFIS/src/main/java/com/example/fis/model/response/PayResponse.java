package com.example.fis.model.response;

import com.example.fis.entity.Order;
import com.example.fis.enums.StatusPay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayResponse {
    private Long id;
    private String codePay;
    private String namePay;
    private StatusPay status;
    private List<Order> orderList;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;
}
