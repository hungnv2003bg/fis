package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.model.request.user.UserSaveRequest;
import com.example.demo.model.request.user.UserUpdateRequest;
import com.example.demo.model.response.UserResponse;
import com.example.demo.repository.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private final RoleRepo repo;

    public User toUser(UserSaveRequest userSaveRequest) {
        User user = new User();
        user.setId(userSaveRequest.getId());
        user.setCodeUser(userSaveRequest.getCodeUser());
        user.setEmail(userSaveRequest.getEmail());
        user.setPassword(userSaveRequest.getPassword());
        user.setName(userSaveRequest.getName());
        user.setPhone(userSaveRequest.getPhone());
        user.setGender(userSaveRequest.getGender());
        user.setStatusUser(userSaveRequest.getStatusUser());
        user.setCreateDate(userSaveRequest.getCreateDate());
        user.setRole(repo.findById(userSaveRequest.getRoleId()).get());
        return user;
    }

    public User toUser(UserUpdateRequest userUpdateRequest) {
        User user = new User();
        user.setEmail(userUpdateRequest.getEmail());
        user.setPassword(userUpdateRequest.getPassword());
        user.setName(userUpdateRequest.getName());
        user.setPhone(userUpdateRequest.getPhone());
        user.setGender(userUpdateRequest.getGender());
        user.setStatusUser(userUpdateRequest.getStatusUser());
        user.setUpdateDate(userUpdateRequest.getUpdateDate());
        user.setRole(repo.findById(userUpdateRequest.getRoleId()).get());
        return user;
    }

    public UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setCodeUser(user.getCodeUser());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setName(user.getName());
        userResponse.setPhone(user.getPhone());
        userResponse.setGender(user.getGender());
        userResponse.setStatusUser(user.getStatusUser());
        userResponse.setCreateDate(user.getCreateDate());
        userResponse.setUpdateDate(user.getUpdateDate());
        userResponse.setRole(user.getRole());
        return userResponse;
    }
}
