package edu.platform.domains.region.service;

import edu.platform.domains.region.model.response.ProvinceResponse;

import java.util.List;

public interface ProvinceService {
    List<ProvinceResponse> getAllProvinces();
}
