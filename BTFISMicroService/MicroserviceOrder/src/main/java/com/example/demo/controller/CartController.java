package com.example.demo.controller;

import com.example.demo.exception.BusinessCode;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.request.cart.CartSaveRequest;
import com.example.demo.model.response.CartResponse;
import com.example.demo.model.response.ResponseCartDTO;
import com.example.demo.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController extends BaseController {
    private final CartService cartService;

    @GetMapping("{userId}")
    public ResponseEntity getCart(@PathVariable Long userId) {
        try {
            List<ResponseCartDTO> responseCartDTOS = cartService.getCart(userId);
            return success(responseCartDTOS);
        } catch (Exception ex) {
            return error(new BusinessException(BusinessCode.NOT_FOUND));
        }
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody CartSaveRequest saveRequest) {
        try {
            ResponseCartDTO responseCartDTO = cartService.addProductToCart(saveRequest);
            return success(responseCartDTO);
        } catch (Exception ex) {
            return error(new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("{cartId}")
    public ResponseEntity updateCart(@PathVariable Long cartId, @RequestBody CartSaveRequest saveRequest) {
        try {
            CartResponse cartResponse = cartService.updateCart(cartId, saveRequest);
            return success(cartResponse);
        } catch (Exception ex) {
            return error(new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR));
        }
    }

    @DeleteMapping("{cartId}")
    public ResponseEntity deleteCart(@PathVariable Long cartId) {
        try {
            ResponseEntity.ok(cartService.deleteCart(cartId));
            return success();
        } catch (Exception e) {
            return error(new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR));
        }
    }

}
