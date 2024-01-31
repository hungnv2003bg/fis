package com.example.demo.service.impl;

import com.example.demo.entity.Cart;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.CartMapper;
import com.example.demo.model.request.cart.CartSaveRequest;
import com.example.demo.model.response.CartResponse;
import com.example.demo.model.response.ProductDTO;
import com.example.demo.model.response.ResponseCartDTO;
import com.example.demo.model.response.UserDTO;
import com.example.demo.repo.CartRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.demo.validation.CartValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private CartRepo cartRepo;

    private CartMapper cartMapper;

    private UserService userService;

    private ProductService productService;

    private final CartValidation cartValidation;


    @Override
    public List<ResponseCartDTO> getCart(Long userId) {
        List<ResponseCartDTO> responseCartDTOS = new ArrayList<>();
        List<Cart> carts = cartRepo.findByCustomerId(userId);
        for (Cart cart : carts) {
            ResponseCartDTO responseCartDTO = new ResponseCartDTO();
            UserDTO userDTO = userService.getUserById(cart.getCustomerId());
            ProductDTO productDTO = productService.getProductById(cart.getProductId());

            CartResponse cartResponse = cartMapper.toCartResponse(cart);
            responseCartDTO.setCart(cartResponse);
            responseCartDTO.setCustomerId(userDTO.getId());
            responseCartDTO.setProduct(productDTO);

            responseCartDTOS.add(responseCartDTO);
        }
        return responseCartDTOS;
    }

    @Override
    public ResponseCartDTO addProductToCart(CartSaveRequest cartSaveRequest) {
        cartValidation.validateData(cartSaveRequest);

        UserDTO userDTO = userService.getUserById(cartSaveRequest.getCustomerId());
        ProductDTO productDTO = productService.getProductById(cartSaveRequest.getProductId());
        Optional<Cart> cartOptional = cartRepo.findCartByCustomerIdAndProductId(userDTO.getId(), productDTO.getId());
        Cart cart;
        if (cartOptional.isEmpty()) {
            cart = cartMapper.toCart(cartSaveRequest);
            cart.setCreateDate(LocalDateTime.now());
            cart.setCustomerId(userDTO.getId());
            cart.setProductId(productDTO.getId());
        } else {
            cart = cartOptional.get();
            cart.setQuantity(cart.getQuantity() + cartSaveRequest.getQuantity());
        }
        cartRepo.save(cart);

        ResponseCartDTO responseCartDTO = new ResponseCartDTO();
        responseCartDTO.setCustomerId(userDTO.getId());
        responseCartDTO.setCart(cartMapper.toCartResponse(cart));
        responseCartDTO.setProduct(productDTO);

        return responseCartDTO;
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
    public List<ResponseCartDTO> deleteCart(Long id) {
        Optional<Cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.CART_NOT_FOUD);
        }
        cartRepo.deleteById(id);
        Long userId = cartOptional.get().getCustomerId();
        return getCart(userId);
    }

    @Override
    public CartResponse getCartResponse(Long id) {
        Cart cart = cartRepo.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.CART_NOT_FOUD));
        return cartMapper.toCartResponse(cart);
    }

}
