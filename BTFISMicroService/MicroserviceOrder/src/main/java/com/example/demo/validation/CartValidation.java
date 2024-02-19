package com.example.demo.validation;

import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.model.request.cart.CartSaveRequest;
import com.example.demo.model.response.ProductDTO;
import com.example.demo.model.response.UserDTO;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CartValidation {
    private final UserService userService;
    private final ProductService productService;

    public CartValidation(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

//    public void validateData(CartSaveRequest cartSaveRequest) {
//        if (cartSaveRequest.getQuantity() <= 0) {
//            throw new BusinessException(ErrorCode.INVALID_QUANTITY_INPUT);
//        }
//
//        UserDTO userDTO = userService.getUserById(cartSaveRequest.getCustomerId());
//        if (userDTO == null) {
//            throw new BusinessException(ErrorCode.USER_NOT_FOUD);
//        }
//        ProductDTO productDTO = productService.getProductById(cartSaveRequest.getProductId());
//        if (productDTO == null) {
//            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUD);
//        }
//    }
}
