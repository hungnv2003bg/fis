package edu.platform.domains.staff.model.request;

import lombok.Data;

@Data
public class StaffAuthRequest {
    private String account;
    private String password;
}
