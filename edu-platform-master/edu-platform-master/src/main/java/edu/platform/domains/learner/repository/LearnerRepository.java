package edu.platform.domains.learner.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.learner.model.entity.Learner;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearnerRepository extends GenericRepository<Learner, Long> {
    Optional<Learner> findByEmailAndPassword(String email, String password);

    Optional<Learner> findByEmail(String email);
}
