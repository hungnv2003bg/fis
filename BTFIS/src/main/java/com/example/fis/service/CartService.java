package com.example.fis.service;

import com.example.fis.model.response.CartResponse;
import com.example.fis.model.request.cart.CartSaveRequest;

import java.util.List;

public interface CartService {

    public CartResponse addProductToCart(CartSaveRequest cartSaveRequest);

    public List<CartResponse> getCart(Long userId);

    public CartResponse updateCart(Long cartId, CartSaveRequest saveRequest);

    public List<CartResponse> deleteCart(Long id);

}
