package com.example.demo.service.impl;

import com.example.demo.entity.Cart;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.CartMapper;
import com.example.demo.model.request.cart.CartSaveRequest;
import com.example.demo.model.response.CartResponse;
import com.example.demo.model.response.ProductResponse;
import com.example.demo.model.response.ResponseCartDTO;
import com.example.demo.model.response.UserResponse;
import com.example.demo.repo.CartRepo;
import com.example.demo.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;

    private final RestTemplate restTemplate;

    private final CartMapper cartMapper;

    @Override
    public List<ResponseCartDTO> getCart(Long userId) {
        List<ResponseCartDTO> responseCartDTOS = new ArrayList<>();
        List<Cart> carts = cartRepo.findByCustomerId(userId);
        for (Cart cart : carts) {
            ResponseCartDTO responseCartDTO = new ResponseCartDTO();
            UserResponse userResponse =
                    restTemplate.getForObject("http://localhost:8080/user/" + cart.getCustomerId(), UserResponse.class);
            ProductResponse productResponse =
                    restTemplate.getForObject("http://localhost:8081/product/" + cart.getProductId(), ProductResponse.class);

            CartResponse cartResponse = cartMapper.toCartResponse(cart);
            responseCartDTO.setCart(cartResponse);
            responseCartDTO.setCustomerId(userResponse.getId());
            responseCartDTO.setProduct(productResponse);

            responseCartDTOS.add(responseCartDTO);
        }
        return responseCartDTOS;
    }

    @Override
    public ResponseCartDTO addProductToCart(CartSaveRequest cartSaveRequest) {
        if (cartSaveRequest.getQuantity() <= 0) {
            throw new BusinessException(ErrorCode.INVALID_QUANTITY_INPUT);
        }
        ResponseEntity<UserResponse> userResponseEntity = restTemplate.exchange(
                "http://localhost:8080/user/{userId}",
                HttpMethod.GET,
                null,
                UserResponse.class,
                cartSaveRequest.getCustomerId()
        );

        ResponseEntity<ProductResponse> productResponseEntity = restTemplate.exchange(
                "http://localhost:8081/product/{productId}",
                HttpMethod.GET,
                null,
                ProductResponse.class,
                cartSaveRequest.getProductId()
        );
        UserResponse userResponse = userResponseEntity.getBody();
        ProductResponse productResponse = productResponseEntity.getBody();

        Optional<Cart> cartOptional =
                cartRepo.findCartByCustomerIdAndProductId(userResponse.getId(), productResponse.getId());

        Cart cart;
        if (cartOptional.isEmpty()) {
            cart = cartMapper.toCart(cartSaveRequest);
            cart.setCreateDate(LocalDateTime.now());
            cart.setCustomerId(userResponse.getId());
            cart.setProductId(productResponse.getId());
        } else {
            cart = cartOptional.get();
            cart.setQuantity(cart.getQuantity() + cartSaveRequest.getQuantity());
        }
        cartRepo.save(cart);
        ResponseCartDTO responseCartDTO = new ResponseCartDTO();
        responseCartDTO.setCustomerId(userResponse.getId());
        responseCartDTO.setCart(cartMapper.toCartResponse(cart));
        responseCartDTO.setProduct(productResponse);

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

}
