package edu.platform.domains.instructor.model.request;

import lombok.Data;

@Data
public class InstructorAuthRequest {
    private String account;
    private String password;
}
