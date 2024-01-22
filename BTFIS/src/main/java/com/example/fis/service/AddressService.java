package com.example.fis.service;

import com.example.fis.model.response.AddressResponse;
import com.example.fis.model.request.address.AddressSaveRequest;
import com.example.fis.model.request.address.AddressUpdateRequest;

import java.util.List;

public interface AddressService {
    public List<AddressResponse> getAddressUser(Long userId);

    public AddressResponse addAddress(AddressSaveRequest addressSaveRequest);

    public AddressResponse updateAddress(Long id, AddressUpdateRequest updateRequest);

    public List<AddressResponse> deleteAddress(Long id);
}
