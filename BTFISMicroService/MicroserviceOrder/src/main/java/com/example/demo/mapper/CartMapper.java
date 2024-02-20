package com.example.demo.mapper;

import com.example.demo.entity.Cart;
import com.example.demo.model.request.cart.CartSaveRequest;
import com.example.demo.model.request.cart.CartUpdateRequest;
import com.example.demo.model.response.CartResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CartMapper {

    public Cart toCart(CartSaveRequest cartSaveRequest) {
        Cart cart = new Cart();
        cart.setId(cartSaveRequest.getId());
        cart.setCustomerId(cartSaveRequest.getCustomerId());
        cart.setProductId(cartSaveRequest.getProductId());
        cart.setQuantity(cartSaveRequest.getQuantity());
        cart.setCreateDate(cartSaveRequest.getCreateDate());
        return cart;
    }

    public Cart toCart(CartUpdateRequest cartUpdateRequest) {
        Cart cart = new Cart();
        cart.setCustomerId(cartUpdateRequest.getCustomerId());
        cart.setProductId(cartUpdateRequest.getProductId());
        cart.setQuantity(cartUpdateRequest.getQuantity());
        cart.setUpdateDate(cartUpdateRequest.getUpdateDate());
        return cart;
    }


    public CartResponse toCartResponse(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());
        cartResponse.setQuantity(cart.getQuantity());
        cartResponse.setProductId(cart.getProductId());
        cartResponse.setCreateDate(cart.getCreateDate());
        cartResponse.setUpdateDate(cart.getUpdateDate());
        return cartResponse;
    }


}
