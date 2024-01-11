package edu.platform.domains.region.model.entity;

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
public class Province extends BaseEntity {

    @Column(nullable = false)
    private String name;
}
