package com.example.demo.model.request.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSaveRequest {
    Integer id;

    String username;

    String password;

    String fullname;

    String email;

    String role;
}
