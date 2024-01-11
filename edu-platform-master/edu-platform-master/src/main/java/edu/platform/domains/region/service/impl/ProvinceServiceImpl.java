package edu.platform.domains.region.service.impl;

import edu.platform.domains.region.mapper.ProvinceMapper;
import edu.platform.domains.region.model.response.ProvinceResponse;
import edu.platform.domains.region.repository.ProvinceRepository;
import edu.platform.domains.region.service.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceRepository provinceRepository;
    private ProvinceMapper provinceMapper;

    @Override
    public List<ProvinceResponse> getAllProvinces() {
        return provinceRepository.findAll()
                .stream()
                .map(provinceMapper::to)
                .collect(Collectors.toList());
    }
}
