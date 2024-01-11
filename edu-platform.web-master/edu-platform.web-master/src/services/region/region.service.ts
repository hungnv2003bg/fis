import http from "./region.api";
import {ProvincesResponse} from "./response/ProvincesResponse";
import {DistrictsResponse} from "./response/DistrictsResponse";
import {WardsResponse} from "./response/WardsResponse";

const getProvinces = () => {
  return http.get<ProvincesResponse>(`/region/provinces`);
}

const getDistricts = (provinceId: number) => {
  return http.get<DistrictsResponse>(`/region/districts`, {
    params: {
      'province_id': provinceId
    }
  });
}

const getWards = (districtId: number) => {
  return http.get<WardsResponse>(`/region/wards`, {
    params: {
      'district_id': districtId
    }
  })
}

export const RegionService = {
  getProvinces,
  getDistricts,
  getWards
}