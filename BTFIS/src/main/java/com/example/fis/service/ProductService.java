package com.example.fis.service;

import com.example.fis.model.response.ProductResponse;
import com.example.fis.model.request.product.ProductSaveRequest;
import com.example.fis.model.request.product.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProducts();

    List<ProductResponse> delete(Long id);

    ProductResponse saveProduct(ProductSaveRequest productSaveRequest);

    ProductResponse updateProduct(Long id, ProductUpdateRequest productUpdateRequest);

    ProductResponse getProduct(Long id);
}
