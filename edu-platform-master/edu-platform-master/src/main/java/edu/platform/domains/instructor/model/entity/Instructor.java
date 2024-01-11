package edu.platform.domains.instructor.model.entity;

import edu.platform.application.base.model.BaseEntity;
import edu.platform.domains.instructor.constant.InstructGender;
import edu.platform.domains.instructor.constant.InstructorStatus;
import edu.platform.domains.instructor.constant.InstructorVerifyStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Instructor extends BaseEntity {

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer yearOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InstructGender gender;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long provinceId;

    @Column(nullable = false)
    private Long districtId;

    @Column(nullable = false)
    private Long wardId;

    @Column
    private Boolean onlineCourseDeliver = false;

    @Column
    private Boolean inPersonCourseDeliver = false;

    @Column(nullable = false)
    private String activeCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InstructorStatus status;

    @Column(length = 2000)
    private String avatarFileName;

    @Column(length = 2000)
    private String diplomaFileName;

    @Column(length = 2000)
    private String idPassportFileName;

    @Column(length = 2000)
    private String certificatesFileName;

    @Column
    private Boolean isVerified = false;

    @Column
    @Enumerated(EnumType.STRING)
    private InstructorVerifyStatus verifyStatus;
}
