package com.example.fis.mapper;

import com.example.fis.entity.Cart;
import com.example.fis.model.response.CartResponse;
import com.example.fis.model.request.cart.CartSaveRequest;
import com.example.fis.model.request.cart.CartUpdateRequest;
import com.example.fis.repository.ProductRepo;
import com.example.fis.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CartMapper {
    private final UserRepo userRepo;

    private final ProductRepo productRepo;

    public Cart toCart(CartSaveRequest cartSaveRequest) {
        Cart cart = new Cart();
        cart.setId(cartSaveRequest.getId());
        cart.setCustomer(userRepo.findById(cartSaveRequest.getCustomerId()).get());
        cart.setProduct(productRepo.findById(cartSaveRequest.getProductId()).get());
        cart.setQuantity(cartSaveRequest.getQuantity());
        cart.setCreateDate(cartSaveRequest.getCreateDate());
        return cart;
    }

    public Cart toCart(CartUpdateRequest cartUpdateRequest) {
        Cart cart = new Cart();
        cart.setCustomer(userRepo.findById(cartUpdateRequest.getCustomerId()).get());
        cart.setProduct(productRepo.findById(cartUpdateRequest.getProductId()).get());
        cart.setQuantity(cartUpdateRequest.getQuantity());
        cart.setUpdateDate(cartUpdateRequest.getUpdateDate());
        return cart;
    }


    public CartResponse toCartResponse(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());
        cartResponse.setCustomer(cart.getCustomer());
        cartResponse.setProduct(cart.getProduct());
        cartResponse.setQuantity(cart.getQuantity());
        cartResponse.setCreateDate(cart.getCreateDate());
        cartResponse.setUpdateDate(cart.getUpdateDate());
        return cartResponse;

    }
}
