package edu.platform.domains.learner.model.entity;

import edu.platform.application.base.model.BaseEntity;
import edu.platform.domains.learner.constant.LearnerStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@ToString
public class Learner extends BaseEntity {

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String email;

    @Column
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer yearOfBirth;

    @Column(nullable = false)
    private Long provinceId;

    @Column(nullable = false)
    private Long districtId;

    @Column(nullable = false)
    private Long wardId;

    @Column
    private Boolean onlineCourseInterest = false;

    @Column
    private Boolean inPersonCourseInterest = false;

    @Column(nullable = false)
    private Boolean isChildAccount;

    @Column(nullable = false)
    private String activeCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LearnerStatus status;

    @Column(length = 2000)
    private String avatarFileName;
}
