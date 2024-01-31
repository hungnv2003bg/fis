package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.request.user.UserSaveRequest;
import com.example.demo.model.request.user.UserUpdateRequest;
import com.example.demo.model.response.UserResponse;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getUsers() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUD));
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> delete(Long id) {
        Optional<User> deleteOptional = userRepo.findById(id);
        if (deleteOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUD);
        }
        userRepo.deleteById(id);
        return getUsers();
    }

    @Override
    public UserResponse saveUser(UserSaveRequest userSaveRequest) {
        User user = userMapper.toUser(userSaveRequest);
        if (user.getEmail().equals("") || user.getPassword().equals("")) {
            throw new BusinessException(ErrorCode.EMAIL_AND_PASS_NOT_BLANK);
        }
        if (user.getName().equals("")) {
            throw new BusinessException(ErrorCode.NAME_NOT_BLANK);
        }
        if (user.getPhone().equals("")) {
            throw new BusinessException(ErrorCode.PHONE_NOT_BLANK);
        }
        if (user.getGender() == null) {
            throw new BusinessException(ErrorCode.GENDER_NOT_BLANK);
        }
        user.setCreateDate(LocalDateTime.now());
        userRepo.save(user);
        user.setCodeUser("USER" + user.getId());
        userRepo.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUD);
        }
        User user = userOptional.get();
        User updateUser = userMapper.toUser(userUpdateRequest);
        if (user.getEmail().equals("") || user.getPassword().equals("")) {
            throw new BusinessException(ErrorCode.EMAIL_AND_PASS_NOT_BLANK);
        }
        if (user.getName().equals("")) {
            throw new BusinessException(ErrorCode.NAME_NOT_BLANK);
        }
        if (user.getPhone().equals("")) {
            throw new BusinessException(ErrorCode.PHONE_NOT_BLANK);
        }
        if (user.getGender() == null) {
            throw new BusinessException(ErrorCode.GENDER_NOT_BLANK);
        }
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setName(updateUser.getName());
        user.setPhone(updateUser.getPhone());
        user.setGender(updateUser.getGender());
        user.setStatusUser(updateUser.getStatusUser());
        user.setUpdateDate(LocalDateTime.now());
        user.setRole(updateUser.getRole());
        userRepo.save(user);
        return userMapper.toUserResponse(user);
    }
}
