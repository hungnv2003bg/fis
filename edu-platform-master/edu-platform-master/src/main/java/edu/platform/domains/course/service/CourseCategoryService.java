package edu.platform.domains.course.service;

import edu.platform.domains.course.model.response.CourseCategoryResponse;

import java.util.List;

public interface CourseCategoryService {
    List<CourseCategoryResponse> getCourseCategories(Long courseGroupId);
}
