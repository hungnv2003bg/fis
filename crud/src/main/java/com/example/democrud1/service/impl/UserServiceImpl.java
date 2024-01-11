package com.example.democrud1.service.impl;

import com.example.democrud1.exception.BusinessException;
import com.example.democrud1.entity.User;
import com.example.democrud1.exception.ErrorCode;
import com.example.democrud1.mapper.UserMapper;
import com.example.democrud1.model.request.UserSaveRequest;
import com.example.democrud1.model.request.UserUpdateRequest;
import com.example.democrud1.model.response.UserResponse;
import com.example.democrud1.repo.UserRepo;
import com.example.democrud1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo repo;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = repo.findAll();
        System.out.println(users);
        return users.stream().map(userMapper::toUserResponse).collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> delete(Long id) {
        repo.deleteById(id);
        return getUsers();
    }

    @Override
    public UserResponse getUser(Long id) {
        Optional<User> userOptional = repo.findById(id);
        if (userOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        return userMapper.toUserResponse(userOptional.get());
    }

    @Override
    public UserResponse save(UserSaveRequest userSaveRequest) {
        User user = userMapper.toUser(userSaveRequest);
        if (user.getName().equals("")) {
            throw new BusinessException(ErrorCode.USER_NAME_NOT_BLANK);
        }
        if (user.getAge() < 1) {
            throw new BusinessException(ErrorCode.AGE_CAN_NOT_NEGATIVE);
        }
        if (user.getAge().toString().equals("")) {
            throw new BusinessException(ErrorCode.AGE_NOT_BLANK);
        }
        repo.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse update(Long id, UserUpdateRequest userUpdateRequest) {
        Optional<User> userOptional = repo.findById(id);
        if (userOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        User user = userOptional.get();
        User updateUser = userMapper.toUser(userUpdateRequest);
        user.setName(updateUser.getName());
        user.setAge(updateUser.getAge());
        user.setGender(updateUser.getGender());
        return userMapper.toUserResponse(user);
    }
}
