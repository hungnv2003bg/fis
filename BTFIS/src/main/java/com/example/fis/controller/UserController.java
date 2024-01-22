package com.example.fis.controller;

import com.example.fis.model.request.product.ProductSaveRequest;
import com.example.fis.model.request.product.ProductUpdateRequest;
import com.example.fis.model.request.user.UserSaveRequest;
import com.example.fis.model.request.user.UserUpdateRequest;
import com.example.fis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserSaveRequest userSaveRequest) {
        return ResponseEntity.ok(userService.saveUser(userSaveRequest));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest) {
        return ResponseEntity.ok(userService.updateUser(id, userUpdateRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
