package com.example.demo.model.request.product;

import com.example.demo.entity.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveRequest {
    Integer id;

    String name;

    Float price;

    Date createdate;

    Categories categories;
}
