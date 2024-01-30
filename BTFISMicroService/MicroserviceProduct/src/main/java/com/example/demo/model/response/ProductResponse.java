package com.example.demo.model.response;

import com.example.demo.entity.Category;
import com.example.demo.enums.StatusProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
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
    private Category category;
}
