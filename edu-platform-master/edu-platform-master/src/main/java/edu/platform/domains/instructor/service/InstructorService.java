package edu.platform.domains.instructor.service;

import edu.platform.domains.instructor.model.request.*;
import edu.platform.domains.instructor.model.response.InstructorGetListResponse;
import edu.platform.domains.instructor.model.response.InstructorResponse;

public interface InstructorService {
    InstructorResponse save(InstructorSaveRequest request);

    InstructorResponse auth(InstructorAuthRequest request);

    InstructorResponse update(Long id, InstructorUpdateRequest request);

    void changePassword(Long id, InstructorChangePasswordRequest request);

    void active(Long id, InstructorActiveRequest request);

    InstructorGetListResponse getList(InstructorGetListRequest request);
}
