package com.example.fis.model.response;

import com.example.fis.entity.Product;
import com.example.fis.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private Long id;
    private User customer;
    private Product product;
    private Integer quantity;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
