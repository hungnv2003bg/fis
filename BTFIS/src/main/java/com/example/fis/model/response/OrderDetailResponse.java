package com.example.fis.model.response;

import com.example.fis.entity.Order;
import com.example.fis.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailResponse {
    private Long id;
    private Order order;
    private Product product;
    private Integer quantity;
    private Double price;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;
    private String note;
}
