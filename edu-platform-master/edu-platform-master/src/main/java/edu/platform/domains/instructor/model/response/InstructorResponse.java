package edu.platform.domains.instructor.model.response;

import edu.platform.domains.instructor.constant.InstructGender;
import edu.platform.domains.instructor.constant.InstructorStatus;
import edu.platform.domains.instructor.constant.InstructorVerifyStatus;
import lombok.Data;

@Data
public class InstructorResponse {
    private Long id;
    private String familyName;
    private String firstName;
    private String email;
    private Integer yearOfBirth;
    private InstructGender gender;
    private String address;
    private Long provinceId;
    private Long districtId;
    private Long wardId;
    private Boolean onlineCourseDeliver;
    private Boolean inPersonCourseDeliver;
    private InstructorStatus status;
    private Boolean isVerified;
    private InstructorVerifyStatus verifyStatus;
}