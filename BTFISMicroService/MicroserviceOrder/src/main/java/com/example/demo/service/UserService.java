package com.example.demo.service;

import com.example.demo.base.BaseResponse;
import com.example.demo.model.response.UserDTO;

public interface UserService {
    BaseResponse<UserDTO> getUserById(Long id);
}
