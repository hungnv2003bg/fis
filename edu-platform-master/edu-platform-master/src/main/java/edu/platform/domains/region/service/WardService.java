package edu.platform.domains.region.service;

import edu.platform.domains.region.model.response.WardResponse;

import java.util.List;

public interface WardService {

    List<WardResponse> getWards(Long districtId);
}
