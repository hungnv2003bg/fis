package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCartDTO {
    private Long customerId;
    private CartResponse cart;
    private ProductDTO product;
}
