package edu.platform.application.controllers;

import edu.platform.domains.region.model.response.DistrictResponse;
import edu.platform.domains.region.model.response.ProvinceResponse;
import edu.platform.domains.region.model.response.WardResponse;
import edu.platform.domains.region.service.DistrictService;
import edu.platform.domains.region.service.ProvinceService;
import edu.platform.domains.region.service.WardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
public class RegionController extends BaseController {

    private ProvinceService provinceService;
    private DistrictService districtService;
    private WardService wardService;

    @GetMapping("/provinces")
    public ResponseEntity getAllProvinces() {
        List<ProvinceResponse> response = provinceService.getAllProvinces();

        return success(response);
    }

    @GetMapping("/districts")
    public ResponseEntity getDistricts(@RequestParam(name = "province_id") Long provinceId) {
        List<DistrictResponse> response = districtService.getDistricts(provinceId);

        return success(response);
    }

    @GetMapping("/wards")
    public ResponseEntity getAllProvinces(@RequestParam(name = "district_id") Long districtId) {
        List<WardResponse> response = wardService.getWards(districtId);

        return success(response);
    }
}