package com.example.demo.service;

import com.example.demo.model.response.UserDTO;

public interface UserService {
    UserDTO getUserById(Long id);
}
