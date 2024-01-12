package com.example.demo.controller;

import com.example.demo.model.request.product.ProductSaveRequest;
import com.example.demo.model.request.product.ProductUpdateRequst;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductSaveRequest productSaveRequest) {
        return ResponseEntity.ok(productService.saveProduct(productSaveRequest));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id,
                                           @RequestBody ProductUpdateRequst productUpdateRequst) {
        return ResponseEntity.ok(productService.updateProduct(id, productUpdateRequst));
    }
}
