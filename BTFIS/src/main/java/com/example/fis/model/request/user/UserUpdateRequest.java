package com.example.fis.model.request.user;

import com.example.fis.enums.StatusUser;
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
