package edu.platform.domains.learner.model.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class LearnerSaveRequest {
    private String familyName;
    private String firstName;
    private String email;
    private String password;
    private Integer yearOfBirth;
    private Long provinceId;
    private Long districtId;
    private Long wardId;
    private Boolean onlineCourseInterest;
    private Boolean inPersonCourseInterest;
    private String courseCategoryIds;
    private MultipartFile[] avatar;
    private String avatarFileName;
}
