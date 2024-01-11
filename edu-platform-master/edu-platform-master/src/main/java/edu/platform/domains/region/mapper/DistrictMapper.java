package edu.platform.domains.region.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.region.model.entity.District;
import edu.platform.domains.region.model.response.DistrictResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DistrictMapper {

    public DistrictResponse to(District district) {
        DistrictResponse response = new DistrictResponse();
        BeanUtil.refine(district, response, BeanUtil::copyNonNull);

        return response;
    }
}
