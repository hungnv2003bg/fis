package edu.platform.domains.instructor.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.instructor.model.entity.Instructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends GenericRepository<Instructor, Long> {
    Optional<Instructor> findByEmailAndPassword(String account, String password);

    Optional<Instructor> findByEmail(String email);

}
