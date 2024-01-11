package edu.platform.domains.region.service;

import edu.platform.domains.region.model.response.DistrictResponse;

import java.util.List;

public interface DistrictService {
    List<DistrictResponse> getDistricts(Long provinceId);
}
