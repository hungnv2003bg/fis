package edu.platform.domains.staff.model.request;

import lombok.Data;

@Data
public class StaffResetPasswordRequest {
    private Long id;
    private String password;
}
