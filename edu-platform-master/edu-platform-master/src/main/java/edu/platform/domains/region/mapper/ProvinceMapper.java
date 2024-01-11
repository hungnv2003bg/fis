package edu.platform.domains.region.mapper;

import edu.platform.application.utils.BeanUtil;
import edu.platform.domains.region.model.entity.Province;
import edu.platform.domains.region.model.response.ProvinceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProvinceMapper {

    public ProvinceResponse to(Province province) {
        ProvinceResponse response = new ProvinceResponse();
        BeanUtil.refine(province, response, BeanUtil::copyNonNull);

        return response;
    }
}
