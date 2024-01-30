package com.example.demo.controller;

import com.example.demo.model.request.cart.CartSaveRequest;
import com.example.demo.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("{userId}")
    public ResponseEntity<?> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody CartSaveRequest saveRequest) {
        return ResponseEntity.ok(cartService.addProductToCart(saveRequest));
    }

    @PutMapping("{cartId}")
    public ResponseEntity<?> updateCart(@PathVariable Long cartId, @RequestBody CartSaveRequest saveRequest) {
        return ResponseEntity.ok(cartService.updateCart(cartId, saveRequest));
    }

    @DeleteMapping("{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartService.deleteCart(cartId));
    }

}
