package com.example.fis.model.response;

import com.example.fis.entity.Role;
import com.example.fis.enums.StatusUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String codeUser;
    private String email;
    private String password;
    private String name;
    private String phone;
    private Boolean gender;
    private StatusUser statusUser;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Role role;
}
