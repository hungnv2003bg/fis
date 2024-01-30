package com.example.demo.service;


import com.example.demo.model.request.product.ProductSaveRequest;
import com.example.demo.model.request.product.ProductUpdateRequest;
import com.example.demo.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProducts();

    List<ProductResponse> delete(Long id);

    ProductResponse saveProduct(ProductSaveRequest productSaveRequest);

    ProductResponse updateProduct(Long id, ProductUpdateRequest productUpdateRequest);

    ProductResponse getProduct(Long id);
}
