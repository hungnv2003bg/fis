package com.example.demo.service.impl;


import com.example.demo.entity.Product;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.request.product.ProductSaveRequest;
import com.example.demo.model.request.product.ProductUpdateRequest;
import com.example.demo.model.response.ProductResponse;
import com.example.demo.repository.ProductRepo;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(productMapper::toProductResponse).toList();
    }

    @Override
    public List<ProductResponse> delete(Long id) {
        Optional<Product> deleteProduct = productRepo.findById(id);
        if (deleteProduct.isEmpty()) {
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUD);
        }
        productRepo.deleteById(id);
        return getProducts();
    }

    @Override
    public ProductResponse saveProduct(ProductSaveRequest productSaveRequest) {
        Product product = productMapper.toProduct(productSaveRequest);

        if (product.getNameProduct().equals("")) {
            throw new BusinessException(ErrorCode.NAMEPRODUCT_NOT_BLANK);
        }

//        if (product.getPriceInput() == null) {
//            try {
//                Double.parseDouble(String.valueOf(product.getPriceInput()));
//            } catch (NumberFormatException e) {
//                throw new BusinessException(ErrorCode.INVALID_PRICE_INPUT);
//            }
//        } else {
//            throw new BusinessException(ErrorCode.PRICE_NOT_BLANK);
//        }

        if (product.getPriceOutput() == null) {
            throw new BusinessException(ErrorCode.PRICE_NOT_BLANK);
        }

//        if (product.getStatusProduct() != StatusProduct.DANGBAN
//                && product.getStatusProduct() != StatusProduct.HETHANG
//                && product.getStatusProduct() != StatusProduct.NGUNGBAN) {
//            throw new BusinessException(ErrorCode.INVALID_STATUS);
//        }

        if (product.getSoLuongTon() == null || product.getSoLuongDaBan() == null) {
            throw new BusinessException(ErrorCode.QUANTITY_NOT_BLANK);
        }

//        if (productSaveRequest.getCategoryId() == null) {
//            throw new BusinessException(ErrorCode.CATEGORYID_NOT_BLANK);
//        }

        product.setCreateDate(LocalDateTime.now());
        productRepo.save(product);
        product.setCodeProduct("PR" + product.getId());
        productRepo.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductUpdateRequest productUpdateRequest) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUD);
        }

        Product product = productOptional.get();
        Product updateProduct = productMapper.toProduct(productUpdateRequest);

        if (product.getNameProduct().equals("")) {
            throw new BusinessException(ErrorCode.NAMEPRODUCT_NOT_BLANK);
        }

        if (product.getPriceOutput() == null) {
            throw new BusinessException(ErrorCode.PRICE_NOT_BLANK);
        }

        if (product.getSoLuongTon() == null || product.getSoLuongDaBan() == null) {
            throw new BusinessException(ErrorCode.QUANTITY_NOT_BLANK);
        }

        product.setNameProduct(updateProduct.getNameProduct());
        product.setPriceInput(updateProduct.getPriceInput());
        product.setPriceOutput(updateProduct.getPriceOutput());
        product.setUpdatedDate(LocalDateTime.now());
        product.setStatusProduct(updateProduct.getStatusProduct());
        product.setSoLuongTon(updateProduct.getSoLuongTon());
        product.setSoLuongDaBan(updateProduct.getSoLuongDaBan());
        product.setCategory(updateProduct.getCategory());
        productRepo.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUD));
        return productMapper.toProductResponse(product);
    }
}
