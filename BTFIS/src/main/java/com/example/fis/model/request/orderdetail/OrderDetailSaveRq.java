package com.example.fis.model.request.orderdetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailSaveRq {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
    private LocalDateTime createDate;
    private String note;
}
