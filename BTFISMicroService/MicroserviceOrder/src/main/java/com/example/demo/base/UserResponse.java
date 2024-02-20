package com.example.demo.base;

import com.example.demo.model.response.UserDTO;
import lombok.Data;

@Data
public class UserResponse extends BaseResponseInternal {
    private UserDTO data;
}
