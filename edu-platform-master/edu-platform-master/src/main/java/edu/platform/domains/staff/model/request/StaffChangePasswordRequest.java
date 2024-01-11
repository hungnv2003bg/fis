package edu.platform.domains.staff.model.request;

import lombok.Data;

@Data
public class StaffChangePasswordRequest {
    private Long id;
    private String currentPassword;
    private String newPassword;
}
