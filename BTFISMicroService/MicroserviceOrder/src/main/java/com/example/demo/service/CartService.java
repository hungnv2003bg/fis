package com.example.demo.service;


import com.example.demo.model.request.cart.CartSaveRequest;
import com.example.demo.model.response.CartResponse;
import com.example.demo.model.response.ResponseCartDTO;

import java.util.List;

public interface CartService {

    List<ResponseCartDTO> getCart(Long customerId);

    public ResponseCartDTO addProductToCart(CartSaveRequest cartSaveRequest);

    public CartResponse updateCart(Long cartId, CartSaveRequest saveRequest);

    public List<ResponseCartDTO> deleteCart(Long id);

    CartResponse getCartResponse(Long id);

}
