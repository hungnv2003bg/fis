package edu.platform.domains.course.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.course.model.entity.CourseCategory;
import edu.platform.domains.course.model.response.CourseCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseCategoryMapper {

    public CourseCategoryResponse to(CourseCategory courseCategory) {
        CourseCategoryResponse response = new CourseCategoryResponse();
        BeanUtil.refine(courseCategory, response, BeanUtil::copyNonNull);

        return response;
    }
}
