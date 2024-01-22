package com.example.fis.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String codeCategory;
    private String nameCategory;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
