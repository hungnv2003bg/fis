package com.example.demo.service;

import com.example.demo.base.BaseResponseInternal;
import com.example.demo.base.UserResponse;

public interface UserService {
    UserResponse getUserById(Long id);
}
