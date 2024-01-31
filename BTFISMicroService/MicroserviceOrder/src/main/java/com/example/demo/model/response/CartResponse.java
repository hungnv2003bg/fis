package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private Long id;
    private String nameCustomer;
    private Integer quantity;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
