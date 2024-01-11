package edu.platform.domains.course.model.entity;

import edu.platform.application.base.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class CourseCategory extends BaseEntity {
    @Column(nullable = false)
    private String courseCategoryName;

    @Column(nullable = false)
    private String courseCategoryDescription;

    @Column
    private Long courseGroupId;
}
