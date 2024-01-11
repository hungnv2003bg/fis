package edu.platform.domains.staff.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.staff.model.entity.Staff;
import edu.platform.domains.staff.model.request.StaffSaveRequest;
import edu.platform.domains.staff.model.response.StaffResponse;
import org.springframework.stereotype.Component;

@Component
public class StaffMapper {

    public StaffResponse to(Staff staff) {
        StaffResponse response = new StaffResponse();
        BeanUtil.refine(staff, response, BeanUtil::copyNonNull);

        return response;
    }

    public Staff to(StaffSaveRequest request) {
        Staff staff = new Staff();
        BeanUtil.refine(request, staff, BeanUtil::copyNonNull);

        return staff;
    }
}
