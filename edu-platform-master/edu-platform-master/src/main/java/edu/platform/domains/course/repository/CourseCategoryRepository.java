package edu.platform.domains.course.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.course.model.entity.CourseCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCategoryRepository extends GenericRepository<CourseCategory, Long> {

    List<CourseCategory> findAllByCourseGroupId(Long courseGroupId);
}
