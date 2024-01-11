package com.example.demo.mapper;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.Products;
import com.example.demo.model.reponse.ProductReponse;
import com.example.demo.model.request.account.AccountSaveRequest;
import com.example.demo.model.request.product.ProductSaveRequest;
import com.example.demo.model.request.product.ProductUpdateRequst;
import org.springframework.stereotype.Component;

@Component
public class ProductMappper {

    public Products toProduct(ProductSaveRequest productSaveRequest) {
        Products products = new Products();
        products.setId(productSaveRequest.getId());
        products.setName(productSaveRequest.getName());
        products.setPrice(productSaveRequest.getPrice());
        products.setCreatedate(productSaveRequest.getCreatedate());
        products.setCategories(productSaveRequest.getCategories());
        return products;
    }

    public Products toProduct(ProductUpdateRequst productUpdateRequst) {
        Products products = new Products();
        products.setName(productUpdateRequst.getName());
        products.setPrice(productUpdateRequst.getPrice());
        products.setCreatedate(productUpdateRequst.getCreatedate());
        products.setCategories(productUpdateRequst.getCategories());
        return products;
    }

    public ProductReponse toProductReponse(Products products) {
        ProductReponse productReponse = new ProductReponse();
        productReponse.setId(products.getId());
        productReponse.setName(products.getName());
        productReponse.setPrice(products.getPrice());
        productReponse.setCreatedate(products.getCreatedate());
        productReponse.setCategories(products.getCategories());
        return productReponse;
    }


}
