package edu.platform.domains.region.repository;

import edu.platform.application.base.repository.GenericRepository;
import edu.platform.domains.region.model.entity.District;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends GenericRepository<District, Long> {

    List<District> findAllByProvinceId(Long provinceId);
}
