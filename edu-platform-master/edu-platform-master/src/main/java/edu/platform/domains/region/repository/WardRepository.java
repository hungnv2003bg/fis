package edu.platform.domains.region.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.region.model.entity.Ward;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends GenericRepository<Ward, Long> {

    List<Ward> findAllByDistrictId(Long districtId);
}
