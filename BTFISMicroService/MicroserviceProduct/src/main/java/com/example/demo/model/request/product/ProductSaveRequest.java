package com.example.demo.model.request.product;

import com.example.demo.enums.StatusProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveRequest {
    private Long id;
    private String codeProduct;
    private String nameProduct;
    private Double priceInput;
    private Double priceOutput;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;
    private StatusProduct statusProduct;
    private Integer soLuongTon;
    private Integer soLuongDaBan;
    private Long categoryId;
}
