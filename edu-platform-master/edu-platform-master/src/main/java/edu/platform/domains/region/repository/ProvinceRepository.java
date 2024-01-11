package edu.platform.domains.region.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.region.model.entity.Province;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends GenericRepository<Province, Long> {
}
