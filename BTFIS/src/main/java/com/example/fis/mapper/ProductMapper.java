package com.example.fis.mapper;

import com.example.fis.entity.Product;
import com.example.fis.model.response.ProductResponse;
import com.example.fis.model.request.product.ProductSaveRequest;
import com.example.fis.model.request.product.ProductUpdateRequest;
import com.example.fis.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final CategoryRepo repo;

    public Product toProduct(ProductSaveRequest productSaveRequest) {
        Product product = new Product();
        product.setId(productSaveRequest.getId());
        product.setCodeProduct(productSaveRequest.getCodeProduct());
        product.setNameProduct(productSaveRequest.getNameProduct());
        product.setPriceInput(productSaveRequest.getPriceInput());
        product.setPriceOutput(productSaveRequest.getPriceOutput());
        product.setCreateDate(productSaveRequest.getCreateDate());
        product.setStatusProduct(productSaveRequest.getStatusProduct());
        product.setSoLuongTon(productSaveRequest.getSoLuongTon());
        product.setSoLuongDaBan(productSaveRequest.getSoLuongDaBan());
        product.setCategory(repo.findById(productSaveRequest.getCategoryId()).get());
        return product;
    }

    public Product toProduct(ProductUpdateRequest productUpdateRequest) {
        Product product = new Product();
        product.setNameProduct(productUpdateRequest.getNameProduct());
        product.setPriceInput(productUpdateRequest.getPriceInput());
        product.setPriceOutput(productUpdateRequest.getPriceOutput());
        product.setCreateDate(productUpdateRequest.getUpdatedDate());
        product.setStatusProduct(productUpdateRequest.getStatusProduct());
        product.setSoLuongTon(productUpdateRequest.getSoLuongTon());
        product.setSoLuongDaBan(productUpdateRequest.getSoLuongDaBan());
        product.setCategory(repo.findById(productUpdateRequest.getCategoryId()).get());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setCodeProduct(product.getCodeProduct());
        productResponse.setNameProduct(product.getNameProduct());
        productResponse.setPriceInput(product.getPriceInput());
        productResponse.setPriceOutput(product.getPriceOutput());
        productResponse.setCreateDate(product.getCreateDate());
        productResponse.setUpdatedDate(product.getUpdatedDate());
        productResponse.setStatusProduct(product.getStatusProduct());
        productResponse.setSoLuongTon(product.getSoLuongTon());
        productResponse.setSoLuongDaBan(product.getSoLuongDaBan());
        productResponse.setCategory(product.getCategory());
        return productResponse;
    }
}
