package edu.platform.domains.region.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.region.model.entity.Ward;
import edu.platform.domains.region.model.response.WardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WardMapper {

    public WardResponse to(Ward ward) {
        WardResponse response = new WardResponse();
        BeanUtil.refine(ward, response, BeanUtil::copyNonNull);

        return response;
    }
}
