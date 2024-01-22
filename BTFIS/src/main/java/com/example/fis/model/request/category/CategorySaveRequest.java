package com.example.fis.model.request.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorySaveRequest {
    private Long id;
    private String codeCategory;
    private String nameCategory;
    private LocalDateTime createDate;
}
