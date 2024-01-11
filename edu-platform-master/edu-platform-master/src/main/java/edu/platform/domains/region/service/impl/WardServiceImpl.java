package edu.platform.domains.region.service.impl;

import edu.platform.domains.region.mapper.WardMapper;
import edu.platform.domains.region.model.response.WardResponse;
import edu.platform.domains.region.repository.WardRepository;
import edu.platform.domains.region.service.WardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WardServiceImpl implements WardService {

    private WardRepository wardRepository;
    private WardMapper wardMapper;

    @Override
    public List<WardResponse> getWards(Long districtId) {
        return wardRepository.findAllByDistrictId(districtId)
                .stream()
                .map(wardMapper::to)
                .collect(Collectors.toList());
    }
}
