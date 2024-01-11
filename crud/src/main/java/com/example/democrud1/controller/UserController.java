package com.example.democrud1.controller;

import com.example.democrud1.model.request.UserSaveRequest;
import com.example.democrud1.model.request.UserUpdateRequest;
import com.example.democrud1.model.response.UserResponse;
import com.example.democrud1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserSaveRequest user) {
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserUpdateRequest user) {
        return ResponseEntity.ok(service.update(id, user));
    }


}
