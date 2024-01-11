package edu.platform.domains.learner.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.learner.model.entity.LearnerMapping;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LearnerMappingRepository extends GenericRepository<LearnerMapping, Long> {
    Optional<LearnerMapping> findByChildAccountIdAndAdultAccountId(Long id, Long adultAccountId);
}
