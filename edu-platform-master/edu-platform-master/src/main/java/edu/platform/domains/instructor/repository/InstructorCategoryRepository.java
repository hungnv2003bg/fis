package edu.platform.domains.instructor.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.instructor.model.entity.InstructorCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorCategoryRepository extends GenericRepository<InstructorCategory, Long> {
}
