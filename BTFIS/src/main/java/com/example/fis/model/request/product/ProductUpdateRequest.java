package com.example.fis.model.request.product;

import com.example.fis.enums.StatusProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequest {
    private String nameProduct;
    private Double priceInput;
    private Double priceOutput;
    private LocalDateTime updatedDate;
    private StatusProduct statusProduct;
    private Integer soLuongTon;
    private Integer soLuongDaBan;
    private Long categoryId;
}
