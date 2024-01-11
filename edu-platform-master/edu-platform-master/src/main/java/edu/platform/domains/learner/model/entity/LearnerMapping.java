package edu.platform.domains.learner.model.entity;

import edu.platform.application.base.model.BaseEntity;
import edu.platform.domains.learner.constant.LearnerMappingStatus;
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
public class LearnerMapping extends BaseEntity {

    @Column(nullable = false)
    private Long childAccountId;

    @Column(nullable = false)
    private Long adultAccountId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LearnerMappingStatus mappingStatus;

    @Column(nullable = false)
    private String mappingCode;
}
