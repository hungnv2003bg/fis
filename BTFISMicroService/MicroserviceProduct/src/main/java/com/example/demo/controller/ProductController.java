package com.example.demo.controller;


import com.example.demo.exception.BusinessCode;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.request.product.ProductSaveRequest;
import com.example.demo.model.request.product.ProductUpdateRequest;
import com.example.demo.model.response.ProductResponse;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController extends BaseController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        try{
            ProductResponse productResponse = productService.getProduct(id);
            return success(productResponse);
        }catch (Exception ex){
            return error(new BusinessException(BusinessCode.NOT_FOUND));
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductSaveRequest productSaveRequest) {
        return ResponseEntity.ok(productService.saveProduct(productSaveRequest));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductUpdateRequest productUpdateRequest) {
        return ResponseEntity.ok(productService.updateProduct(id, productUpdateRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(productService.delete(id));
    }

}
