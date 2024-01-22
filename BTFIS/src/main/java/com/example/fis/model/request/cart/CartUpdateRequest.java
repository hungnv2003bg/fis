package com.example.fis.model.request.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartUpdateRequest {
    private Long customerId;
    private Long productId;
    private Integer quantity;
    private LocalDateTime updateDate;
}
