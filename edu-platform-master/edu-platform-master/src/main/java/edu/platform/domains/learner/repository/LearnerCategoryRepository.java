package edu.platform.domains.learner.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.learner.model.entity.LearnerCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerCategoryRepository extends GenericRepository<LearnerCategory, Long> {
}
