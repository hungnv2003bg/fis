package com.example.demo.controller;

import com.example.demo.exception.BusinessCode;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.request.user.UserSaveRequest;
import com.example.demo.model.request.user.UserUpdateRequest;
import com.example.demo.model.response.UserResponse;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
            UserResponse userResponse = userService.getUser(id);
            return success(userResponse);
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        try {
            List<UserResponse> userResponse = userService.getUsers();
            return success(userResponse);
        } catch (Exception ex) {
            return error(new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR));
        }
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
