package edu.platform.domains.instructor.model.request;

import lombok.Data;

@Data
public class InstructorChangePasswordRequest {
    private String currentPassword;
    private String newPassword;
}
