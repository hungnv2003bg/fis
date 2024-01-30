package com.example.demo.mapper;

import com.example.demo.entity.Address;
import com.example.demo.model.request.address.AddressSaveRequest;
import com.example.demo.model.request.address.AddressUpdateRequest;
import com.example.demo.model.response.AddressResponse;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressMapper {

    private final UserRepo userRepo;

    public Address toAddress(AddressSaveRequest saveRequest) {
        Address address = new Address();
        address.setId(saveRequest.getId());
        address.setUser(userRepo.findById(saveRequest.getUserId()).get());
        address.setReceiver(saveRequest.getReceiver());
        address.setWardId(saveRequest.getWardId());
        address.setDistrictId(saveRequest.getDistrictId());
        address.setProvinceId(saveRequest.getProvinceId());
        address.setWard(saveRequest.getWard());
        address.setDistrict(saveRequest.getDistrict());
        address.setProvince(saveRequest.getProvince());
        address.setAddressDetail(saveRequest.getAddressDetail());
        address.setPhone(saveRequest.getPhone());
        address.setMainDress(saveRequest.getMainDress());
        address.setCreateDate(saveRequest.getCreateDate());
        address.setStatus(saveRequest.getStatus());
        return address;
    }

    public Address toAddress(AddressUpdateRequest updateRequest) {
        Address address = new Address();
        address.setUser(userRepo.findById(updateRequest.getUserId()).get());
        address.setReceiver(updateRequest.getReceiver());
        address.setWardId(updateRequest.getWardId());
        address.setDistrictId(updateRequest.getDistrictId());
        address.setProvinceId(updateRequest.getProvinceId());
        address.setWard(updateRequest.getWard());
        address.setDistrict(updateRequest.getDistrict());
        address.setProvince(updateRequest.getProvince());
        address.setAddressDetail(updateRequest.getAddressDetail());
        address.setPhone(updateRequest.getPhone());
        address.setMainDress(updateRequest.getMainDress());
        address.setUpdateDate(updateRequest.getUpdateDate());
        address.setStatus(updateRequest.getStatus());
        return address;
    }

    public AddressResponse toAddressReponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setUser(address.getUser());
        addressResponse.setReceiver(address.getReceiver());
        addressResponse.setWardId(address.getWardId());
        addressResponse.setDistrictId(address.getDistrictId());
        addressResponse.setProvinceId(address.getProvinceId());
        addressResponse.setWard(address.getWard());
        addressResponse.setDistrict(address.getDistrict());
        addressResponse.setProvince(address.getProvince());
        addressResponse.setAddressDetail(address.getAddressDetail());
        addressResponse.setPhone(address.getPhone());
        addressResponse.setMainDress(address.getMainDress());
        addressResponse.setCreateDate(address.getCreateDate());
        addressResponse.setUpdateDate(address.getUpdateDate());
        addressResponse.setStatus(address.getStatus());
        return addressResponse;
    }

}
