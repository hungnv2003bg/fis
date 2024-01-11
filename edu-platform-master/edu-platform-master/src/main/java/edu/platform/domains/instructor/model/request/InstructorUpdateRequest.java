package edu.platform.domains.instructor.model.request;

import lombok.Data;

import java.util.List;

@Data
public class InstructorUpdateRequest {
    private String familyName;
    private String firstName;
    private Integer yearOfBirth;
    private String address;
    private Long provinceId;
    private Long districtId;
    private Long wardId;
    private Boolean onlineCourseDeliver;
    private Boolean inPersonCourseDeliver;
    private List<Long> courseCategoryIds;
}
