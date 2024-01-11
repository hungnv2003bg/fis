package edu.platform.domains.staff.model.response;

import edu.platform.domains.staff.constant.StaffStatus;
import lombok.Data;

@Data
public class StaffResponse {
    private Long id;
    private String account;
    private String fullName;
    private String email;
    private String roles;
    private StaffStatus status;
}
