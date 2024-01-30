package com.example.demo.model.request.user;

import com.example.demo.enums.StatusUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

    private String email;
    private String password;
    private String name;
    private String phone;
    private Boolean gender;
    private StatusUser statusUser;
    private LocalDateTime updateDate;
    private Long roleId;
}
