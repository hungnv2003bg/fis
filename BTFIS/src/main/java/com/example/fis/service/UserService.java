package com.example.fis.service;

import com.example.fis.model.response.UserResponse;
import com.example.fis.model.request.user.UserSaveRequest;
import com.example.fis.model.request.user.UserUpdateRequest;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();

    List<UserResponse> delete(Long id);

    UserResponse saveUser(UserSaveRequest userSaveRequest);

    UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest);

    UserResponse getUser(Long id);

}
