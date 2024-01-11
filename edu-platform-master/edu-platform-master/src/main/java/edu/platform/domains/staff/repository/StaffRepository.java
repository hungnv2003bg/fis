package edu.platform.domains.staff.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.staff.model.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends GenericRepository<Staff, Long> {
    Optional<Staff> findByAccountAndPassword(String account, String password);

    Optional<Staff> findByEmail(String email);

    Optional<Staff> findByAccount(String account);
}
