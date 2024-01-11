package edu.platform.domains.course.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.course.model.entity.CourseGroup;
import edu.platform.domains.course.model.response.CourseGroupResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseGroupMapper {

    public CourseGroupResponse to(CourseGroup courseGroup) {
        CourseGroupResponse response = new CourseGroupResponse();
        BeanUtil.refine(courseGroup, response, BeanUtil::copyNonNull);

        return response;
    }
}
