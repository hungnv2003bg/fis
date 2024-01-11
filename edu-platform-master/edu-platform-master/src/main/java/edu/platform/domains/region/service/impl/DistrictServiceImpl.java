package edu.platform.domains.region.service.impl;

import edu.platform.domains.region.mapper.DistrictMapper;
import edu.platform.domains.region.model.response.DistrictResponse;
import edu.platform.domains.region.repository.DistrictRepository;
import edu.platform.domains.region.service.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private DistrictRepository districtRepository;
    private DistrictMapper districtMapper;

    @Override
    public List<DistrictResponse> getDistricts(Long provinceId) {
        return districtRepository.findAllByProvinceId(provinceId)
                .stream()
                .map(districtMapper::to)
                .collect(Collectors.toList());
    }
}
