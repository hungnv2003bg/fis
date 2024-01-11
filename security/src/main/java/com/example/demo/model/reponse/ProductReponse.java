package com.example.demo.model.reponse;

import com.example.demo.entity.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductReponse {
    Integer id;

    String name;

    Float price;

    Date createdate;

    Categories categories;
}
