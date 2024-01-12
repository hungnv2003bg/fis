package com.example.demo.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountReponse {
    Integer id;

    String username;

    String password;

    String fullname;

    String email;

    String role;
}
