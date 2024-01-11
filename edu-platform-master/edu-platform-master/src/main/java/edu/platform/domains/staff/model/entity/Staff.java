package edu.platform.domains.staff.model.entity;

import edu.platform.application.base.model.BaseEntity;
import edu.platform.domains.staff.constant.StaffStatus;
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
public class Staff extends BaseEntity {
    @Column(nullable = false)
    private String account;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String roles;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StaffStatus status;
}
