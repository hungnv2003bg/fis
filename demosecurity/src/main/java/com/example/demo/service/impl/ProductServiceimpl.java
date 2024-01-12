package com.example.demo.service.impl;

import com.example.demo.entity.Products;
import com.example.demo.mapper.ProductMappper;
import com.example.demo.model.reponse.ProductReponse;
import com.example.demo.model.request.product.ProductSaveRequest;
import com.example.demo.model.request.product.ProductUpdateRequst;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceimpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMappper productMappper;

    @Override
    public List<ProductReponse> getProducts() {
        List<Products> products = productRepo.findAll();
        return products.stream().map(productMappper::toProductReponse).toList();
    }

    @Override
    public List<ProductReponse> deleteProduct(Integer id) {
        productRepo.deleteById(id);
        return getProducts();
    }

    @Override
    public ProductReponse getProduct(Integer id) {
        Optional<Products> optionalProducts = productRepo.findById(id);
        return productMappper.toProductReponse(optionalProducts.get());
    }

    @Override
    public ProductReponse saveProduct(ProductSaveRequest productSaveRequest) {
        Products products = productMappper.toProduct(productSaveRequest);
        productRepo.save(products);
        return productMappper.toProductReponse(products);
    }

    @Override
    public ProductReponse updateProduct(Integer id, ProductUpdateRequst productUpdateRequst) {
        Optional<Products> productsOptional = productRepo.findById(id);
        Products products = productsOptional.get();
        Products productUpdate = productMappper.toProduct(productUpdateRequst);
        products.setName(productUpdate.getName());
        products.setPrice(productUpdate.getPrice());
        products.setCreatedate(productUpdate.getCreatedate());
        products.setCategories(productUpdate.getCategories());
        return productMappper.toProductReponse(products);
    }
}
