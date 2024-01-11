package edu.platform.security.jwt.payload;

import lombok.Data;

@Data
public final class Payload {
    private long id;
    private String phoneNumber;
    private String email;
    private String account;
    private String role;
}
