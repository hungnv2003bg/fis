package edu.platform.domains.staff.service;

import edu.platform.domains.staff.model.request.*;
import edu.platform.domains.staff.model.response.StaffGetListResponse;
import edu.platform.domains.staff.model.response.StaffResponse;

public interface StaffService {
    StaffResponse auth(StaffAuthRequest request);

    StaffGetListResponse getList(StaffGetListRequest request);

    StaffResponse save(StaffSaveRequest request);

    void lock(Long staffId);

    void unlock(Long staffId);

    void changePassword(StaffChangePasswordRequest request);

    void resetPassword(StaffResetPasswordRequest request);

    StaffResponse getStaff(Long id);
}
