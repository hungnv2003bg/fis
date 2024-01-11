package edu.platform.domains.learner.model.response;

import edu.platform.domains.learner.constant.LearnerStatus;
import lombok.Data;

@Data
public class LearnerResponse {
    private Long id;
    private String familyName;
    private String firstName;
    private String email;
    private Integer yearOfBirth;
    private Long provinceId;
    private Long districtId;
    private Long wardId;
    private Boolean onlineCourseInterest;
    private Boolean inPersonCourseInterest;
    private LearnerStatus status;
    private Boolean isChildAccount;
}