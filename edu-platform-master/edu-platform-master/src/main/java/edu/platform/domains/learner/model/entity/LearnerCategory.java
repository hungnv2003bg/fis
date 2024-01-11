package edu.platform.domains.learner.model.entity;

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
public class LearnerCategory extends BaseEntity {

    @Column(nullable = false)
    private Long learnerId;

    @Column(nullable = false)
    private Long courseCategoryId;
}
