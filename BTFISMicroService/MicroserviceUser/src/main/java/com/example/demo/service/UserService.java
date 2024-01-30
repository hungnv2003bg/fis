package com.example.demo.service;

import com.example.demo.model.request.user.UserSaveRequest;
import com.example.demo.model.request.user.UserUpdateRequest;
import com.example.demo.model.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();

    UserResponse getUser(Long id);

    List<UserResponse> delete(Long id);

    UserResponse saveUser(UserSaveRequest userSaveRequest);

    UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest);

}
