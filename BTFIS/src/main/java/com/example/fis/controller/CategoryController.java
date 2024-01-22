package com.example.fis.controller;

import com.example.fis.model.request.category.CategorySaveRequest;
import com.example.fis.model.request.category.CategoryUpdateRequest;
import com.example.fis.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CategorySaveRequest categorySaveRequest) {
        return ResponseEntity.ok(categoryService.saveCategory(categorySaveRequest));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryUpdateRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.delete(id));
    }
}
