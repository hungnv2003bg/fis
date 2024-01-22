package com.example.fis.service.impl;

import com.example.fis.entity.Cart;
import com.example.fis.entity.Product;
import com.example.fis.entity.User;
import com.example.fis.exception.BusinessException;
import com.example.fis.exception.ErrorCode;
import com.example.fis.mapper.CartMapper;
import com.example.fis.model.response.CartResponse;
import com.example.fis.model.request.cart.CartSaveRequest;
import com.example.fis.repository.CartRepo;
import com.example.fis.repository.ProductRepo;
import com.example.fis.repository.UserRepo;
import com.example.fis.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartMapper cartMapper;

    private final CartRepo cartRepo;

    private final UserRepo userRepo;

    private final ProductRepo productRepo;

    @Override
    public CartResponse addProductToCart(CartSaveRequest cartSaveRequest) {
        if (cartSaveRequest.getQuantity() <= 0) {
            throw new BusinessException(ErrorCode.INVALID_QUANTITY_INPUT);
        }
        User user = userRepo.findById(cartSaveRequest.getCustomerId())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUD));

        Product product = productRepo.findById(cartSaveRequest.getProductId())
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUD));

        Optional<Cart> cartOptional = cartRepo.findCartByCustomerAndProduct(user, product);

        if (cartOptional.isEmpty()) {
            Cart cart = cartMapper.toCart(cartSaveRequest);
            cart.setCreateDate(LocalDateTime.now());
            cart.setCustomer(user);
            cart.setProduct(product);
            cartRepo.save(cart);
            return cartMapper.toCartResponse(cart);
        } else {
            Cart cart = cartOptional.get();
            cart.setQuantity(cart.getQuantity() + cartSaveRequest.getQuantity());
            cartRepo.save(cart);
            return cartMapper.toCartResponse(cart);
        }
    }


    @Override
    public List<CartResponse> getCart(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUD);
        }
        List<Cart> cartList = cartRepo.findCartsByCustomer(userOptional.get());
        return cartList.stream().map(cartMapper::toCartResponse).toList();
    }

    @Override
    public CartResponse updateCart(Long cartId, CartSaveRequest saveRequest) {
        Optional<Cart> cartOptional = cartRepo.findById(cartId);
        if (cartOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.CART_NOT_FOUD);
        }
        Cart existingCart = cartOptional.get();

        int newQuantity = saveRequest.getQuantity();
        if (newQuantity <= 0) {
            cartRepo.delete(existingCart);
        } else {
            existingCart.setQuantity(newQuantity);
            cartRepo.save(existingCart);
        }
        return cartMapper.toCartResponse(existingCart);
    }


    @Override
    public List<CartResponse> deleteCart(Long id) {
        Optional<Cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.CART_NOT_FOUD);
        }
        cartRepo.deleteById(id);
        return getCart(cartOptional.get().getCustomer().getId());
    }
}
