package edu.platform.domains.course.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.course.model.entity.CourseGroup;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseGroupRepository extends GenericRepository<CourseGroup, Long> {
}
