package com.example.demo.service;

import com.example.demo.model.reponse.ProductReponse;
import com.example.demo.model.request.product.ProductSaveRequest;
import com.example.demo.model.request.product.ProductUpdateRequst;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductReponse> getProducts();

    List<ProductReponse> deleteProduct(Integer id);

    ProductReponse getProduct(Integer id);

    ProductReponse saveProduct(ProductSaveRequest productSaveRequest);

    ProductReponse updateProduct(Integer id, ProductUpdateRequst productUpdateRequst);
}
