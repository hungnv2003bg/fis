package com.example.democrud1.mapper;

import com.example.democrud1.entity.User;
import com.example.democrud1.model.request.UserSaveRequest;
import com.example.democrud1.model.request.UserUpdateRequest;
import com.example.democrud1.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserSaveRequest userSaveRequest) {
        User user = new User();
        user.setName(userSaveRequest.getName());
        user.setAge(userSaveRequest.getAge());
        user.setGender(userSaveRequest.getGender());
        return user;
    }

    public User toUser(UserUpdateRequest userUpdateRequest) {
        User user = new User();
        user.setName(userUpdateRequest.getName());
        user.setAge(userUpdateRequest.getAge());
        user.setGender(userUpdateRequest.getGender());
        return user;
    }

    public UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setAge(user.getAge());
        userResponse.setGender(user.getGender());
        return userResponse;
    }
}
