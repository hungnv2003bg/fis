package edu.platform.domains.course.service;

import edu.platform.domains.course.model.response.CourseGroupResponse;

import java.util.List;

public interface CourseGroupService {
    List<CourseGroupResponse> getAllCourseGroupResponses();
}
