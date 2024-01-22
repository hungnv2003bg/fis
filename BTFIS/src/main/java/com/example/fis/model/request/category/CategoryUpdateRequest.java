package com.example.fis.model.request.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateRequest {
    private String nameCategory;
    private LocalDateTime updateDate;
}
