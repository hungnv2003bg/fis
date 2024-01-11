package edu.platform.domains.instructor.model.request;

import edu.platform.domains.instructor.constant.InstructGender;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InstructorSaveRequest {
    private String familyName;
    private String firstName;
    private String email;
    private String password;
    private InstructGender gender;
    private Integer yearOfBirth;
    private String address;
    private Long provinceId;
    private Long districtId;
    private Long wardId;
    private Boolean onlineCourseDeliver;
    private Boolean inPersonCourseDeliver;
    private String courseCategoryIds;
    private MultipartFile[] avatar;
    private MultipartFile[] diploma;
    private MultipartFile[] idPassport;
    private MultipartFile[] certificates;
    private String avatarFileName;
    private String diplomaFileName;
    private String idPassportFileName;
    private String certificatesFileName;
}
