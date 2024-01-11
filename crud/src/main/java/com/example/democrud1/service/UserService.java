package com.example.democrud1.service;

import com.example.democrud1.model.request.UserSaveRequest;
import com.example.democrud1.model.request.UserUpdateRequest;
import com.example.democrud1.model.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();

    List<UserResponse> delete(Long id);

    UserResponse getUser(Long id);

    UserResponse save(UserSaveRequest userSaveRequest);

    UserResponse update(Long id, UserUpdateRequest userUpdateRequest);

}
