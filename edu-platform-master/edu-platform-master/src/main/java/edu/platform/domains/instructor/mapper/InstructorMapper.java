package edu.platform.domains.instructor.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.instructor.model.entity.Instructor;
import edu.platform.domains.instructor.model.request.InstructorSaveRequest;
import edu.platform.domains.instructor.model.request.InstructorUpdateRequest;
import edu.platform.domains.instructor.model.response.InstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InstructorMapper {

    public Instructor to(InstructorSaveRequest request) {
        Instructor instructor = new Instructor();
        BeanUtil.refine(request, instructor, BeanUtil::copyNonNull);

        return instructor;
    }

    public Instructor to(InstructorUpdateRequest request, Instructor instructor) {
        BeanUtil.refine(request, instructor, BeanUtil::copyNonNull);

        return instructor;
    }

    public InstructorResponse to(Instructor instructor) {
        InstructorResponse response = new InstructorResponse();
        BeanUtil.refine(instructor, response, BeanUtil::copyNonNull);

        return response;
    }
}
