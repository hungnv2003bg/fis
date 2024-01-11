package edu.platform.domains.course.model.response;

import lombok.Data;

@Data
public class CourseCategoryResponse {
    private Long id;
    private String courseCategoryName;
    private String courseCategoryDescription;
}
