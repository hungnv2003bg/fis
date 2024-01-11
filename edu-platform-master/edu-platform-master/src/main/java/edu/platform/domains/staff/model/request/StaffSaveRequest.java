package edu.platform.domains.staff.model.request;

import lombok.Data;

@Data
public class StaffSaveRequest {
    private String account;
    private String password;
    private String fullName;
    private String email;
    private String roles;
}
