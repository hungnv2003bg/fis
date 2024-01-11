package edu.platform.domains.course.model.response;

import lombok.Data;

@Data
public class CourseGroupResponse {
    private Long id;
    private String courseGroupName;
    private String courseGroupDescription;
}
